package com.project.udacity.newsapp.models;

public class News {

    private String mArticleTitle;
    private String mArticleAuthor;
    private String mArticleSection;
    private String mArticlePublishDate;
    private String mArticleUrl;

    public News(String articleTitle, String articleAuthor, String articleSection, String articlePublishDate, String articleUrl) {
        mArticleTitle = articleTitle;
        mArticleAuthor = articleAuthor;
        mArticleSection = articleSection;
        mArticlePublishDate = articlePublishDate;
        mArticleUrl = articleUrl;
    }

    public String getArticleTitle() {
        return mArticleTitle;
    }
    public String getArticleAuthor() { return mArticleAuthor; }
    public String getArticleSection() {
        return mArticleSection;
    }
    public String getArticlePublishDate() {
        return mArticlePublishDate;
    }
    public String getArticleUrl() {
        return mArticleUrl;
    }
}
