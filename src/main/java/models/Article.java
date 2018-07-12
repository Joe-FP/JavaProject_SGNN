package models;

import java.util.Date;

public class Article {

    private int id;
    private String title;
    private CategoryType categoryType;
    private Journalist journalist;
    private Date publishDate;
    private String articleSummary;
    private String fullArticle;
    private int articleHits;

    public Article(){

    }

    public Article(String title, CategoryType categoryType, Journalist journalist, Date publishDate, String articleSummary, String fullArticle) {
        this.title = title;
        this.categoryType = categoryType;
        this.journalist = journalist;
        this.publishDate = publishDate;
        this.articleSummary = articleSummary;
        this.fullArticle = fullArticle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getFullArticle() {
        return fullArticle;
    }

    public void setFullArticle(String fullArticle) {
        this.fullArticle = fullArticle;
    }

    public int getArticleHits() {
        return articleHits;
    }

    public void setArticleHits(int articleHits) {
        this.articleHits = articleHits;
    }
}
