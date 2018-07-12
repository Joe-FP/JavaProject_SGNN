import models.Article;
import models.CategoryType;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class JournalistTest {

  Journalist journalist;
  Article article;

  @Before
  public void setUp() throws Exception {
    Date date = new Date(2018, 7, 7);
    journalist = new Journalist("Ron Burgundy");
    article = new Article("Title", CategoryType.BUSINESS, journalist, date,"Article Summary", "Full Article");
  }

  @Test
  public void checkCanAddArticle() {
    journalist.addArticle(article);
    assertEquals(1, journalist.getArticles().size());
  }
}
