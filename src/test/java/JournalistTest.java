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

import static org.junit.Assert.assertEquals;

public class JournalistTest {

  Journalist journalist;
  Article article;

  @Before
  public void setUp() throws Exception {
    journalist = new Journalist("Ron Burgundy", JournalismType.Broadcast);
    article = new Article(journalist, "title", "2018-08-01", CategoryType.Tech, "location.jpg", "summary", "full article");
    journalist.addArticle(article);
  }

  @Test
  public void checkCanAddArticle() {
    assertEquals(1, journalist.getArticles().size());
  }

}
