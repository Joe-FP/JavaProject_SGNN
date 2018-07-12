package db;

import models.Article;
import models.Journalist;
import models.News;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(News.class);

        
    }
}
