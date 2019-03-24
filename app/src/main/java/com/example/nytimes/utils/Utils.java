package com.example.nytimes.utils;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.example.nytimes.R;

import androidx.annotation.Nullable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Emad Mohamed Oun on 3/24/2019.
 * Rytalo
 * e.oun@rytalo.com
 */
public class Utils {
    /**
     * Check if network available of not
     *
     * @return true if is available
     */
    public static boolean isNetworkAvailable(final Context context, boolean showToast) {
        if (context != null) {
            ConnectivityManager mConnectivity =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = null;
            if (mConnectivity != null) {
                mNetworkInfo = mConnectivity.getActiveNetworkInfo();
            }
            boolean isNetworkAvailable = mNetworkInfo != null && mNetworkInfo.isConnectedOrConnecting();
            if (!isNetworkAvailable && showToast) {
                Toast.makeText(context, context.getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            }
            return isNetworkAvailable;
        } else {
            return false;
        }
    }

    public static Dialog initLoadingDialog(Context context, @Nullable Disposable disposable) {
        final Dialog dialog = new Dialog(context, R.style.TransDialog);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(dialog1 -> {
            if (disposable != null && !disposable.isDisposed()) disposable.dispose();
        });
        return dialog;
    }
}
