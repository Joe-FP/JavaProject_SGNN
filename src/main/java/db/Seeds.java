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
        Journalist journalist4 = new Journalist("Ford Prefect", JournalismType.FOREIGN);
        DBHelper.save(journalist4);
        Journalist journalist5 = new Journalist("Ford Prefect", JournalismType.PUBLIC_RELATIONS);
        DBHelper.save(journalist5);

        Article article1 = new Article(journalist5, "Headline", CategoryType.WORLD, "/images1", "summary", "full article");
        DBHelper.save(article1);
        Article article2 = new Article(journalist2, "Lorem Ipsum", CategoryType.POLITICS, "/images2", "summary", "full article");
        DBHelper.save(article2);
        Article article3 = new Article(journalist3, "Lorem Ipsum", CategoryType.INDUSTRY, "/images3", "summary", "full article");
        DBHelper.save(article3);
        Article article4 = new Article(journalist1, "Headline", CategoryType.BUSINESS, "/images1", "summary", "full article");
        DBHelper.save(article4);
        Article article5 = new Article(journalist4, "Headline", CategoryType.EDUCATION, "/images1", "summary", "full article");
        DBHelper.save(article5);
        Article article6 = new Article(journalist5, "Headline", CategoryType.ENTERTAINMENT, "/images1", "summary", "full article");
        DBHelper.save(article6);
        Article article7 = new Article(journalist1, "Headline", CategoryType.TECH, "/images1", "summary", "full article");
        DBHelper.save(article7);
        Article article8 = new Article(journalist2, "Headline", CategoryType.POLITICS, "/images1", "summary", "full article");
        DBHelper.save(article8);
        Article article9 = new Article(journalist3, "Headline", CategoryType.INDUSTRY, "/images1", "summary", "full article");
        DBHelper.save(article9);
        Article article10 = new Article(journalist4, "Headline", CategoryType.WORLD, "/images1", "summary", "full article");
        DBHelper.save(article10);
        Article article11 = new Article(journalist5, "Headline", CategoryType.POLITICS, "/images1", "summary", "full article");
        DBHelper.save(article11);
        Article article12 = new Article(journalist3, "Headline", CategoryType.CRIME, "/images1", "summary", "full article");
        DBHelper.save(article12);
        Article article13 = new Article(journalist2, "Headline", CategoryType.BUSINESS, "/images1", "summary", "full article");
        DBHelper.save(article13);
        Article article14 = new Article(journalist4, "Headline", CategoryType.WORLD, "/images1", "summary", "full article");
        DBHelper.save(article14);
        Article article15 = new Article(journalist1, "Headline", CategoryType.INDUSTRY, "/images1", "summary", "full article");
        DBHelper.save(article15);
        Article article16 = new Article(journalist5, "Headline", CategoryType.ENTERTAINMENT, "/images1", "summary", "full article");
        DBHelper.save(article16);
        Article article17 = new Article(journalist3, "Headline", CategoryType.EDUCATION, "/images1", "summary", "full article");
        DBHelper.save(article17);
        Article article18 = new Article(journalist4, "Headline", CategoryType.HEALTH, "/images1", "summary", "full article");
        DBHelper.save(article18);
        Article article19 = new Article(journalist2, "Headline", CategoryType.BUSINESS, "/images1", "summary", "full article");
        DBHelper.save(article19);
        Article article20 = new Article(journalist5, "Headline", CategoryType.CRIME, "/images1", "summary", "full article");
        DBHelper.save(article20);
    }
}
