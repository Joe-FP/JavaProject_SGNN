import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.JournalismType;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class ArticleTest {

    Journalist journalist;
    Article article;

//    @Before
//    public void setUp() throws Exception {
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
//        article = new Article(journalist, "title", date, CategoryType.Weather, "location.jpg", "summary", "full article");
//        DBHelper.save(article);
//    }

//    @Test
//    public void canAddArticleHit() {
//        article.addArticleHit();
//        assertEquals(1, article.getArticleHits());
//    }
}
