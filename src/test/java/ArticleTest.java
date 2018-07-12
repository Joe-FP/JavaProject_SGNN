import models.Article;
import models.CategoryType;
import models.Journalist;
import org.junit.Before;

import java.util.Date;

public class ArticleTest {

    Article article;
    Journalist journalist;

    @Before
    public void setUp() throws Exception {
        Date date = new Date(2018, 7, 7);
        journalist = new Journalist("Ron Burgundy");
        article = new Article("Title", CategoryType.BUSINESS, journalist, date,"Article Summary", "Full Article");
    }
}
