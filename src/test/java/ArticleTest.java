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
        journalist = new Journalist("Ron Burgundy", JournalismType.BROADCAST);
        DBHelper.save(journalist);
        String date = new SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance().getTime());
        article = new Article(journalist, "title", "12/06/2018", CategoryType.Politics, "location.jpg", "summary", "full article");
        DBHelper.save(article);
    }

    @Test
    public void canAddArticleHit() {
        article.addArticleHit();
        assertEquals(1, article.getArticleHits());
    }
}
