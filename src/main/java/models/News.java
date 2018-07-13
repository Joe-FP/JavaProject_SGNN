package models;

import java.util.ArrayList;
import java.util.List;

public class News {

    private String stationName;
    private List<Journalist> journalists;
    private List<Article> articles;

    public News(String stationName) {
        this.stationName = stationName;
        this.articles = new ArrayList<Article>();
        this.journalists = new ArrayList<Journalist>();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Journalist> getJournalists() {
        return journalists;
    }

    public void setJournalists(List<Journalist> journalists) {
        this.journalists = journalists;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addJournalist(Journalist journalist){
        this.journalists.add(journalist);
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

}
