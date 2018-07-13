import db.DBHelper;
import models.*;
import org.junit.Before;
import org.junit.Test;

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
        article = new Article(journalist, "title", CategoryType.POLITICS, "location.jpg", "summary", "full article");
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
