package models;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeMath.round;

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
    private String publishD;
    private List<Rating> ratings;

    public Article(){

    }

    public Article(Journalist journalist, String title, String publishD, CategoryType categoryType, String imagePath, String articleSummary, String fullArticle) {
        this.journalist = journalist;
        this.title = title;
        this.publishD = publishD;
        this.categoryType = categoryType;
        this.imagePath = imagePath;
        this.articleSummary = articleSummary;
        this.fullArticle = fullArticle;
        this.articleHits = 0;
        this.ratings = new ArrayList<Rating>();
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

    @Column(name="fullArticle", columnDefinition = "TEXT")
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

    @Column(name="publishD")
    public String getPublishD() {
        return publishD;
    }

    public void setPublishD(String publishD) { this.publishD = publishD; }

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> rating) {
        this.ratings = rating;
    }

    public double averageRating(){
        double count = 0;
        if(this.ratings.size() == 0){ return count;}
        for (Rating rating : ratings) {
            count += rating.getRating();
        }
        double average = count / ratings.size();
        return round(average, 1);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }









}
