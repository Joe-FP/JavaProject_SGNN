import models.Article;
import models.CategoryType;
import models.Journalist;
import models.News;
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
        Date date = new Date(2018, 7, 7);
        journalist = new Journalist("Ron Burgundy");
        article = new Article("Title", CategoryType.BUSINESS, journalist, date,"Article Summary", "Full Article");
        news = new News();
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
