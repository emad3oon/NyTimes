package com.example.nytimes;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nytimes.connection.APIUrls;
import com.example.nytimes.models.ArticlesModel;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Emad Mohamed Oun on 3/25/2019.
 * Rytalo
 * e.oun@rytalo.com
 */
public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.article_details_tv) TextView articleDetailsTextView ;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        getIntentData();
    }

    private void getIntentData() {
        if (getIntent() !=null){
            if (getIntent().getParcelableExtra(APIUrls.FLAGS.FLAG_ARTICLE_DETAILS) !=null){
                ArticlesModel.ResultsDataModel articleDetailsModel = getIntent().getParcelableExtra(APIUrls.FLAGS.FLAG_ARTICLE_DETAILS);
                fillViewWithData(articleDetailsModel);
            }
        }
    }

    private void fillViewWithData(ArticlesModel.ResultsDataModel articleDetailsModel) {
        articleDetailsTextView.setText(articleDetailsModel.getAbstractX());
    }
}
