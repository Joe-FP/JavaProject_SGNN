package models;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name ="journalists")
public class Journalist {

    private int id;
    private String name;
    private ArrayList<Article> articles;
    private int rating;
    private JournalismType journalismType;

    public Journalist() {
    }

    public Journalist(String name, JournalismType journalismType) {
        this.name = name;
        this.articles = new ArrayList<Article>();
        this.rating = 0;
        this.journalismType = journalismType;
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name ="journalismType")
    public JournalismType getJournalismType() {
        return journalismType;
    }

    public void setJournalismType(JournalismType journalismType) {
        this.journalismType = journalismType;
    }

//    public double getAverageRating(){
//        for( Article article : this.articles){
//            this.rating.add(article.getRating());
//        }
//        double avgRating = (double)rating / (double)articles.length;
//        return avgRating;
//    }
}
