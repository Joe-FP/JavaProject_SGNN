package models;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name ="journalists")
public class Journalist {

    private int id;
    private String name;
    private ArrayList<Article> articles;

    public Journalist() {
    }

    public Journalist(String name) {
        this.name = name;
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

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
