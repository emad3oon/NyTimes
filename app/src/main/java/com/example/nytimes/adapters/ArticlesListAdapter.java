package com.example.nytimes.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nytimes.DetailsActivity;
import com.example.nytimes.R;
import com.example.nytimes.connection.APIUrls;
import com.example.nytimes.models.ArticlesModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.nytimes.connection.APIUrls.FLAGS.FLAG_ARTICLE_DETAILS;

/**
 * Created by Emad Mohamed Oun on 3/24/2019.
 * Rytalo
 * e.oun@rytalo.com
 */

public class ArticlesListAdapter extends RecyclerView.Adapter<ArticlesListAdapter.MyViewHolder> {

    private List<ArticlesModel.ResultsDataModel> articlesList;
    private Context context ;

    public ArticlesListAdapter(Context context,
                               List<ArticlesModel.ResultsDataModel> articlesList) {
        this.articlesList = articlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_articles, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        fillViewWithData(holder, position);
    }

    @SuppressLint({"SetTextI18n", "ResourceType"})
    private void fillViewWithData(MyViewHolder holder, int position) {
        ArticlesModel.ResultsDataModel articleData = articlesList.get(position);
        holder.articleTitleTextView.setText(articleData.getTitle());
        holder.articleDescriptionTextView.setText(articleData.getAbstractX());
        holder.authorNameTextView.setText(articleData.getSource());
        holder.articleDateTextView.setText(articleData.getPublished_date());
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.article_iv) CircleImageView articleImageView;
        @BindView(R.id.article_title_tv) TextView articleTitleTextView;
        @BindView(R.id.article_description_tv) TextView articleDescriptionTextView;
        @BindView(R.id.author_name_tv) TextView authorNameTextView;
        @BindView(R.id.article_date_tv) TextView articleDateTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick
        void onClick(View view) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(APIUrls.FLAGS.FLAG_ARTICLE_DETAILS, articlesList.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }

}
