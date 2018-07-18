package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="journalists")
public class Journalist {

    private int id;
    private String name;
    private List<Article> articles;
    private JournalismType journalismType;

    public Journalist() {
    }

    public Journalist(String name, JournalismType journalismType) {
        this.name = name;
        this.journalismType = journalismType;
        this.articles = new ArrayList<Article>();
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

    @OneToMany(mappedBy="journalist", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    @Column(name ="journalismType")
    public JournalismType getJournalismType() {
        return journalismType;
    }

    public void setJournalismType(JournalismType journalismType) {
        this.journalismType = journalismType;
    }

}
