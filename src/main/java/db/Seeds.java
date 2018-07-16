package db;

import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(News.class);

        Journalist journalist1 = new Journalist("Vivian Rook", JournalismType.Broadcast);
        DBHelper.save(journalist1);
        Journalist journalist2 = new Journalist("Tony Hills", JournalismType.Sport);
        DBHelper.save(journalist2);
        Journalist journalist3 = new Journalist("Ford Prefect", JournalismType.Communication);
        DBHelper.save(journalist3);
        Journalist journalist4 = new Journalist("Bridget Jones", JournalismType.Foreign);
        DBHelper.save(journalist4);
        Journalist journalist5 = new Journalist("Matt Anders", JournalismType.PR);
        DBHelper.save(journalist5);

        Article article1 = new Article(journalist1, "Title_1", "2018-08-22", CategoryType.Weather, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "full article");
        DBHelper.save(article1);
        Article article2 = new Article(journalist1, "Title_2", "2018-06-23", CategoryType.Business, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "full article");
        DBHelper.save(article2);
        Article article3 = new Article(journalist1, "Title_3", "2018-06-24", CategoryType.Industry, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "full article");
        DBHelper.save(article3);
        Article article4 = new Article(journalist2, "Title_4", "2018-07-22", CategoryType.Crime, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "full article");
        DBHelper.save(article4);
        Article article5 = new Article(journalist3, "Title_5", "2018-07-23", CategoryType.Tech, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "full article");
        DBHelper.save(article5);
        Article article6 = new Article(journalist1, "Title_6", "2018-07-24", CategoryType.Weather, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "full article");
        DBHelper.save(article6);
        Article article7 = new Article(journalist1, "Title_7", "2018-08-13", CategoryType.Business, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "full article");
        DBHelper.save(article7);
        Article article8 = new Article(journalist1, "Title_8", "2018-06-12", CategoryType.Weather, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "full article");
        DBHelper.save(article8);
        Article article9 = new Article(journalist2, "Title_9", "2018-08-15", CategoryType.Crime, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "full article");
        DBHelper.save(article9);
        Article article10 = new Article(journalist3, "Title_10", "2018-08-16", CategoryType.Tech, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "full article");
        DBHelper.save(article10);

    }
}
