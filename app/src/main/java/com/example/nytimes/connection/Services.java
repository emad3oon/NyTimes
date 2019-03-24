package com.example.nytimes.connection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import com.example.nytimes.utils.Utils;
import com.pnikosis.materialishprogress.ProgressWheel;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Authored by Emad Mohamed on 30 MAy, 2018.
 * Contact: emad.3oon@gmail.com
 * Aziz by Phorous.com © 2018.
 */

public class Services {

    private Activity context;
    private OnResponseReceived responseReceived;
    private Validator validator;
    private Dialog progressDialog;

    public Services(Activity context, OnResponseReceived responseReceived) {
        this.context = context;
        this.responseReceived = responseReceived;
        validator = new Validator(context, responseReceived);
    }

    @SuppressLint("CheckResult")
    public void getArticlesList(CompositeDisposable disposables, String apiKey) {
        if (isConnected()) {
            APIService apiService = RetroConnect.getRetrofitInstance().create(APIService.class);
            apiService.getArticlesList(apiKey)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> {
                        showProgressDialog(context, disposable);
                        disposables.add(disposable);
                    })
                    .doOnComplete(this::hideProgressDialog)
                    .subscribe(articlesModel -> validator.validateResponse(
                            articlesModel,
                            APIUrls.FLAGS.FLAG_ARTICLES_LIST
                            ), throwable -> {
                                hideProgressDialog();
                                onFail(throwable);
                            }
                    );

        }
    }


    private void showProgressDialog(Context context, Disposable disposable) {
        if (progressDialog == null) {
            progressDialog = Utils.initLoadingDialog(context, disposable);
        }
        if (!progressDialog.isShowing()) progressDialog.show();
    }

    private void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
    }

    private boolean isConnected() {
        return Utils.isNetworkAvailable(context, true);
    }

    private void onFail(@NonNull Throwable t) {
        responseReceived.onResponse(false, APIUrls.FLAGS.FLAG_SERVER_ERROR, null);
        Log.e("response", t.toString());
    }

    /**
     * Interface to pass service response when arrived.
     */
    public interface OnResponseReceived {

        /**
         * Pass model filled with data from the service
         *
         * @param isSuccess true if response is completely success
         * @param flag      name of called service to receive the right one when this method called
         */
        void onResponse(boolean isSuccess, String flag, Object model);
    }


    private RequestBody createPart(Object data) {
        return RequestBody.create(MultipartBody.FORM, String.valueOf(data));
    }
}
