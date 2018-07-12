import models.Journalist;

public class Runner {

    Journalist journalist1 = new Journalist("Ron Burgundy");
    DBHelper.save(journalist1);
    Journalist journalist2 = new Journalist("Buck Tamland");
    DBHelper.save(journalist2);
}
