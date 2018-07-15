import db.DBHelper;
import models.*;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NewsTest {

    Journalist journalist;
    Article article;
    News news;

    @Before
    public void setUp() throws Exception {
        news = new News("SGNN");
        journalist = new Journalist("Ron Burgundy", JournalismType.BROADCAST);
        DBHelper.save(journalist);
        String date = new SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance().getTime());
        article = new Article(journalist, "title", "12/06/2018", CategoryType.Politics, "location.jpg", "summary", "full article");
        DBHelper.save(article);
    }

    @Test
    public void canAddJournalist() {
        news.addJournalist(journalist);
        assertEquals(1, news.getJournalists().size());
    }

    @Test
    public void canAddArticle() {
        news.addArticle(article);
        assertEquals(1, news.getArticles().size());
    }
}
