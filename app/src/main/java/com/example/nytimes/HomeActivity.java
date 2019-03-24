package com.example.nytimes;

import android.os.Bundle;

import com.example.nytimes.adapters.ArticlesListAdapter;
import com.example.nytimes.connection.Services;
import com.example.nytimes.models.ArticlesModel;
import com.example.nytimes.utils.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Emad Mohamed Oun on 3/24/2019.
 * Rytalo
 * e.oun@rytalo.com
 */

public class HomeActivity extends AppCompatActivity implements Services.OnResponseReceived {

    @BindView(R.id.articles_rv) RecyclerView articlesRecyclerView ;

    private CompositeDisposable compositeDisposable ;

    private Services services ;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        callArticlesApi();
    }

    private void init() {
        setUpRecyclerView();
        setUpConnection();
    }

    private void setUpRecyclerView() {
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpConnection() {
        compositeDisposable = new CompositeDisposable();
        services = new Services(this, this);
    }

    private void callArticlesApi() {
        String apiKey = "zZTKiAWakVWh5GWLPHIK3LZsAEOaagE3";
        services.getArticlesList(compositeDisposable, apiKey);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @Override
    protected void onPause() {
        super.onPause();
        compositeDisposable.clear();
    }

    @Override
    public void onResponse(boolean isSuccess, String flag, Object model) {
        if (isSuccess){
            ArticlesModel articlesModel = (ArticlesModel) model;
            if (articlesModel.getStatus().equals("OK")){
                ArticlesListAdapter articlesListAdapter = new ArticlesListAdapter(this,
                        articlesModel.getResults());
                articlesRecyclerView.setAdapter(articlesListAdapter);
            }
        }
    }
}
