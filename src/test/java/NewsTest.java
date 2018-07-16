import db.DBHelper;
import models.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NewsTest {

    Journalist journalist;
    Article article;
    News news;

//    @Before
//    public void setUp() throws Exception {
//        news = new News("SGNN");
//        journalist = new Journalist("Ron Burgundy", JournalismType.Broadcast);
//        DBHelper.save(journalist);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date;
//
//        try {
//            date = simpleDateFormat.parse("2012-12-24");
//        } catch (ParseException e) {
//            date = null;
//            e.printStackTrace();
//        }
//
//        article = new Article(journalist, "title", date, CategoryType.Crime, "location.jpg", "summary", "full article");
//        DBHelper.save(article);
//    }
//
//    @Test
//    public void canAddJournalist() {
//        news.addJournalist(journalist);
//        assertEquals(1, news.getJournalists().size());
//    }
//
//    @Test
//    public void canAddArticle() {
//        news.addArticle(article);
//        assertEquals(1, news.getArticles().size());
//    }
}
