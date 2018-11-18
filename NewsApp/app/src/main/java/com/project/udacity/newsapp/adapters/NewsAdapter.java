package com.project.udacity.newsapp.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.udacity.newsapp.R;
import com.project.udacity.newsapp.models.News;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView articleTitleView = listItemView.findViewById(R.id.article_title);
        articleTitleView.setText(currentNews.getArticleTitle());

        TextView articleAuthorView = listItemView.findViewById(R.id.article_author);
        articleAuthorView.setText(currentNews.getArticleAuthor());

        TextView articleSectionView = listItemView.findViewById(R.id.article_section);
        articleSectionView.setText(currentNews.getArticleSection());

        TextView articlePublishDateView = listItemView.findViewById(R.id.article_publish_date);
        articlePublishDateView.setText(currentNews.getArticlePublishDate());


        return listItemView;
    }

}