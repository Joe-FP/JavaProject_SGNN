package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="articles")
public class Article {

    private int id;
    private Journalist journalist;
    private String title;
    private CategoryType categoryType;
    private String imagePath;
    private String articleSummary;
    private String fullArticle;
    private int articleHits;
    private Date publishDate;
    private int rating;
    private boolean accepted;

    public Article(){

    }

    public Article(Journalist journalist, String title, CategoryType categoryType, String imagePath, String articleSummary, String fullArticle) {
        this.journalist = journalist;
        this.title = title;
        this.categoryType = categoryType;
        this.imagePath = imagePath;
        this.articleSummary = articleSummary;
        this.fullArticle = fullArticle;
        this.articleHits = 0;
        this.rating = 0;
        this.accepted = false;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="journalist_id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="categoryType")
    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Column(name="imagePath")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name="articleSummary")
    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    @Column(name="fullArticle")
    public String getFullArticle() {
        return fullArticle;
    }

    public void setFullArticle(String fullArticle) {
        this.fullArticle = fullArticle;
    }

    @Column(name="articleHits")
    public int getArticleHits() {
        return articleHits;
    }

    public void setArticleHits(int articleHits) {
        this.articleHits = articleHits;
    }

    @Column(name="publishDate")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Column(name="rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name="accepted")
    public boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void addArticleHit(){
        this.articleHits ++;
    }

}
