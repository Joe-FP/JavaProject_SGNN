import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.JournalismType;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class ArticleTest {

    Journalist journalist;
    Article article;

    @Before
    public void setUp() throws Exception {
        journalist = new Journalist("Ron Burgundy", JournalismType.Broadcast);
        DBHelper.save(journalist);
        article = new Article(journalist, "title", "test", CategoryType.Weather, "location.jpg", "summary", "full article");
        DBHelper.save(article);
    }

//    @Test
//    public void canAddArticleHit() {
//        article.addArticleHit();
//        assertEquals(1, article.getArticleHits());
//    }
}
