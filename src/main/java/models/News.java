package models;

import java.util.ArrayList;

public class News {

    private ArrayList<Journalist> journalists;
    private ArrayList<Article> articles;

    public News() {
        this.articles = new ArrayList<Article>();
        this.journalists = new ArrayList<Journalist>();
    }

    public ArrayList<Journalist> getJournalists() {
        return journalists;
    }

    public void setJournalists(ArrayList<Journalist> journalists) {
        this.journalists = journalists;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void addJournalist(Journalist journalist){
        this.journalists.add(journalist);
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

}
