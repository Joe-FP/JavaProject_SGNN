package db;

import models.*;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Article.class);

        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(News.class);

        Journalist journalist1 = new Journalist("Vivian Rook", JournalismType.BROADCAST);
        DBHelper.save(journalist1);
        Journalist journalist2 = new Journalist("Tony Hills", JournalismType.SPORT);
        DBHelper.save(journalist2);
        Journalist journalist3 = new Journalist("Ford Prefect", JournalismType.COMMUNICATIONS);
        DBHelper.save(journalist3);

        Article article1 = new Article(journalist1, "Lorem Ipsum", CategoryType.CRIME, "/images1", "summary", "full article");
        DBHelper.save(article1);
        Article article2 = new Article(journalist2, "Lorem Ipsum", CategoryType.POLITICS, "/images2", "summary", "full article");
        DBHelper.save(article2);
        Article article3 = new Article(journalist3, "Lorem Ipsum", CategoryType.INDUSTRY, "/images3", "summary", "full article");
        DBHelper.save(article3);

    }
}
