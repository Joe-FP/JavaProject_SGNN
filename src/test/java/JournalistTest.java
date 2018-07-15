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

import static org.junit.Assert.assertEquals;

public class JournalistTest {

  Journalist journalist;
  Article article;

  @Before
  public void setUp() throws Exception {
    journalist = new Journalist("Ron Burgundy", JournalismType.BROADCAST);
    String date = new SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance().getTime());
    article = new Article(journalist, "title", "12/06/2018", CategoryType.Politics, "location.jpg", "summary", "full article");
    article.setRating(5);
    journalist.addArticle(article);
  }

  @Test
  public void checkCanAddArticle() {
    assertEquals(1, journalist.getArticles().size());
  }

  @Test
  public void getAverageRating() {
    assertEquals(5, journalist.averageRating(), 0.1);
  }
}
