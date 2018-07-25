package db;

import models.*;

import java.util.*;

public class Test {

    public static void seedData() {
        DBHelper.deleteAll(Rating.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        // Author -- Article Title -- Publish Date -- Image
        String [][] arrData = {
                {"Michael Copeland", "The Difference Between AI, Machine Learning and Deep Learning", "2016-07-29", "1.png" } ,
                {"Luke Dormehl", "What is an Artificial Neural Network?", "2018-11-18", "2.jpg" } ,
                {"Kishan Maladkar", "6 Types of Artifical Neural Network Currently Being Used", "2018-01-15", "3.jpg" } ,
                {"Max Tegmark", "Benefits and Risks of Artificial Intelligence", "2016-06-01", "4.jpg" } ,
                {"Ian Sample", "Google DeepMind's AI Program Learns Human Navigation Skills", "2018-05-09", "5.jpg" } ,
                {"Fred Alcober", "How TensorFlow is Powering Technology Around the World", "2018-05-09", "6-1.jpg" } ,
                {"Carlos E. Perez", "Should Deep Learning Use Complex Numbers?", "2017-09-24", "7-2.png" } ,
                {"Carson Sestili", "Deep Learning: Going Deeper toward Meaningful Patterns in Complex Data", "2018-02-12", "8.jpg" } ,
                {"Keith D. Foote", "A Brief History of Deep Learning", "2012-02-07", "9.png" } ,
                {"Abby Norman", "NASA: AI Will Lead the Future of Space Explortion", "2017-06-27", "10.jpg" } ,
                {"Ava Chisling", "The Pivotal Role AI Plays in the Future of Space Travel", "2017-04-20", "11.jpeg" } ,
                {"Steven Levy", "What Deep Blue Tells Us About AI in 2017", "2017-05-23", "12.jpeg" } ,
        };

        String strArticle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum venenatis urna at libero scelerisque dignissim malesuada eget mi. Morbi eget nulla pharetra arcu tempus ullamcorper ac id nulla. Phasellus ante neque, feugiat eu volutpat sed, blandit nec leo. Etiam luctus nulla velit, sed ullamcorper leo ultricies lobortis. Cras rhoncus fermentum nulla at faucibus. Praesent sodales neque in lorem commodo, eget imperdiet lectus congue. Duis quis turpis turpis. Nam eleifend at leo fringilla rhoncus.\n" +
                "\n\n" + "Suspendisse imperdiet, tellus in bibendum pellentesque, tortor lacus imperdiet dolor, vel facilisis libero massa sodales metus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus in finibus risus, vel maximus mi. Etiam magna leo, mollis in nisi sed, elementum mollis risus. Donec suscipit nibh tristique egestas placerat. In auctor quam rhoncus, tempus velit et, vulputate magna. Fusce ornare neque et odio lacinia aliquet. Curabitur volutpat justo eu egestas elementum. Morbi volutpat sagittis dignissim. Donec risus sapien, tincidunt eu magna a, tempus laoreet tellus. Donec quis pulvinar metus. Nulla facilisi.\n" +
                "\n\n" + "Praesent consectetur velit odio. Donec tempor aliquam elit quis rhoncus. Etiam vel ex pulvinar mi porta ultricies in nec augue. Maecenas facilisis ex id quam vestibulum, eu elementum nulla viverra. Maecenas felis nunc, cursus eget velit id, congue vehicula leo. Etiam nulla mi, viverra euismod mauris sed, feugiat condimentum quam. Cras ullamcorper vitae tortor quis fringilla. Integer justo orci, accumsan eget dignissim a, mollis vitae tortor. Quisque libero dolor, tempor sit amet enim et, blandit dictum ipsum. Praesent in vestibulum odio, non fringilla ante. Maecenas posuere ullamcorper nisi, sed ullamcorper ante mollis ut. In varius accumsan consequat. Donec tristique augue id vestibulum congue. Ut sit amet gravida elit.\n" +
                "\n\n" + "Nullam ac commodo nisl. Suspendisse et urna est. Sed sit amet ante massa. Aenean eu ex auctor, egestas elit sit amet, feugiat augue. Maecenas ornare, ipsum a fermentum aliquam, velit purus dictum nulla, eget lobortis urna leo quis augue. Nam et orci mattis, euismod sem at, semper tortor. Vestibulum quis lacinia massa, non rhoncus sem. Sed odio sem, ultrices non eleifend sed, imperdiet non libero. Suspendisse quis tincidunt purus. Quisque convallis a diam a vulputate. Nulla id est sed leo tempus viverra. Proin pulvinar nulla at augue hendrerit laoreet. Sed a rhoncus magna. Mauris nisl ipsum, rutrum eu eleifend sit amet, auctor ac nibh. Duis tortor tellus, imperdiet congue turpis in, fringilla molestie elit. Cras iaculis, dolor ultricies viverra luctus, magna ligula suscipit magna, ut iaculis est tellus sollicitudin ligula.\n" +
                "\n\n" + "Pellentesque porta in sem sit amet rutrum. Sed fermentum, nulla sed dictum tincidunt, massa massa posuere enim, id rutrum mauris tellus quis dui. Fusce tellus eros, tempus eu tellus vitae, convallis varius ante. Phasellus turpis odio, condimentum et augue at, tempor luctus elit. Nam at tincidunt sapien, vitae semper urna. Aliquam viverra mi ex. Duis fermentum ipsum et sollicitudin dapibus. Fusce sed purus urna.";

        String strSummary = "This is some summary text about the article.";

        for(int i=0; i<arrData.length; i++) {
            Journalist journalist = new Journalist(arrData[i][0], JournalismType.getRandomType());
            DBHelper.save(journalist);
            String imagegPath = "/images/article-images/" + arrData[i][3];
            Article article = new Article(journalist, arrData[i][1], arrData[i][2], CategoryType.AI, imagegPath, strSummary, strArticle);
            DBHelper.save(article);
            applyRandomRating(article);
        }
    }

    private static void applyRandomRating(Article article){
        Random r = new Random();
        Random i = new Random();
        int numRatings = i.nextInt(150-50) + 50;
        for (int times = 0; times <= numRatings; times++){
            int rating = r.nextInt(5-1) + 1;
            Rating articleRating = new Rating(article, rating);
            DBHelper.save(articleRating);
        }
    }
}





//        for (String key : titleImage.keySet()) {
//            String title = key;
//            String imagePath = "/images/article-images/" + titleImage.get(key);
//            Article article = new Article(journalist, title, getRandomDate(), CategoryType.getRandomType(), imagePath, "This is summary test.", strArticle);
//            Random d = new Random(); int hits = d.nextInt(250-50) + 50; article.setArticleHits(hits);
//            DBHelper.save(article);
//            applyRandomRating(article);
//        }
//    }
//
//        for (String key : titleImage.keySet()) {
//            String title = key;
//            String imagePath = "/images/article-images/" + titleImage.get(key);
//            Random t = new Random();
//            Journalist journalist = journalists.get(t.nextInt(journalists.size()-0) + 0);
//            Article article = new Article(journalist, title, getRandomDate(), CategoryType.getRandomType(), imagePath, "This is summary test.", strArticle);
//            Random d = new Random(); int hits = d.nextInt(250-50) + 50; article.setArticleHits(hits);
//            DBHelper.save(article);
//            applyRandomRating(article);
//        }
//
//    private static String getRandomDate(){
//        Random y = new Random();
//        Random m = new Random();
//        Random d = new Random();
//        int year = y.nextInt(2018-2005) + 2005;
//        String strYear = String.valueOf(year);
//        int month = m.nextInt(12-1) + 1;
//        String strMonth = String.valueOf(month);
//        if(strMonth.length() == 1){ strMonth = "0" + strMonth; }
//        int day = d.nextInt(28-1) + 1;
//        String strDay = String.valueOf(day);
//        if(strDay.length() == 1){ strDay = "0" + strDay; }
//        String date = strYear + "-" + strMonth + "-" + strDay;
//        return date;
//    }
//
//        List<Journalist> journalists = new ArrayList<>();
//        Journalist journalist1 = new Journalist("Michael Copeland", JournalismType.Investigative);
//        journalists.add(journalist1);
//        DBHelper.save(journalist1);
//        Journalist journalist2 = new Journalist("Luke Dormehl", JournalismType.Investigative);
//        journalists.add(journalist2);
//        DBHelper.save(journalist2);
//        Journalist journalist3 = new Journalist("Kishan Maladkar", JournalismType.Investigative);
//        journalists.add(journalist3);
//        DBHelper.save(journalist3);
//        Journalist journalist4 = new Journalist("Max Tegmark", JournalismType.Investigative);
//        journalists.add(journalist4);
//        DBHelper.save(journalist4);
//        Journalist journalist5 = new Journalist("Ian Sample", JournalismType.Investigative);
//        journalists.add(journalist5);
//        DBHelper.save(journalist5);
//        Journalist journalist6 = new Journalist("Fred Alcober", JournalismType.Investigative);
//        journalists.add(journalist6);
//        DBHelper.save(journalist6);
//        Journalist journalist7 = new Journalist("Carlos E. Perez", JournalismType.Investigative);
//        journalists.add(journalist7);
//        DBHelper.save(journalist7);
//        Journalist journalist8 = new Journalist("Carson Sestili", JournalismType.Investigative);
//        journalists.add(journalist8);
//        DBHelper.save(journalist8);
//        Journalist journalist9 = new Journalist("Keith D. Foote", JournalismType.Investigative);
//        journalists.add(journalist9);
//        DBHelper.save(journalist9);
//        Journalist journalist10 = new Journalist("Abby Norman", JournalismType.Investigative);
//        journalists.add(journalist10);
//        DBHelper.save(journalist10);
//        Journalist journalist11 = new Journalist("Ava Chisling", JournalismType.Investigative);
//        journalists.add(journalist11);
//        DBHelper.save(journalist11);
//        Journalist journalist12 = new Journalist("Steven Levy", JournalismType.Investigative);
//        journalists.add(journalist12);
//        DBHelper.save(journalist12);
//
//        HashMap<String, String> titleImage = new HashMap<String, String>();
//        titleImage.put("The Difference Between AI, Machine Learning and Deep Learning", "1.jpg");
//        //Michael Copeland 29/07/16
//        titleImage.put("What is an Artificial Neural Network?", "2.png");
//        // Luke Dormehl 05/11/18
//        titleImage.put("6 Types of Artifical Neural Network Currently Being Used", "3.jpeg");
//        //Kishan Maladkar 15/01/18
//        titleImage.put("Benefits and Risks of Artificial Intelligence", "4.jpg");
//        // Max Tegmark 01/06/16
//        titleImage.put("Google DeepMind's AI Program Learns Human Navigation Skills", "5.jpg");
//        // Ian Sample 09/05/18
//        titleImage.put("How TensorFlow is Powering Technology Around the World", "6.jpg");
//        // Fred Alcober 09/05/18
//        titleImage.put("Should Deep Learning Use Complex Numbers?", "7.jpg");
//        // Carlos E. Perez 24/09/17
//        titleImage.put("Deep Learning: Going Deeper toward Meaningful Patterns in Complex Data", "8.gif");
//        // Carson Sestili 12/02/18
//        titleImage.put("A Brief History of Deep Learning", "9.jpg");
//        // Keith D. Foote 07/02/17
//        titleImage.put("NASA: AI Will Lead the Future of Space Explortion", "10.jpeg");
//        // Abby Norman 27/06/17
//        titleImage.put("The Pivotal Role AI Plays in the Future of Space Travel", "11.jpeg");
//        // Ava Chisling 20/04/17
//        titleImage.put("What Deep Blue Tells Us About AI in 2017", "12.JPG");
//        // Steven Levy 23/05/17

//        Article article1 = new Article(journalist1, "The Difference Between AI, Machine Learning and Deep Learning", "2016-07-29", CategoryType.AI, "/images/article-images/1.jpg", strSummary, strArticle);
//        Article article2 = new Article(journalist2, "What is an Artificial Neural Network?", "2018-11-18", CategoryType.AI, "/images/article-images/2.jpg", strSummary, strArticle);
//        Article article3 = new Article(journalist3, "6 Types of Artifical Neural Network Currently Being Used", "2018-01-15", CategoryType.AI, "/images/article-images/3.jpg", strSummary, strArticle);
//        Article article4 = new Article(journalist4, "Benefits and Risks of Artificial Intelligence", "2016-06-01", CategoryType.AI, "/images/article-images/4.jpg", strSummary, strArticle);
//        Article article5 = new Article(journalist5, "Google DeepMind's AI Program Learns Human Navigation Skills", "2018-05-09", CategoryType.AI, "/images/article-images/5.jpg", strSummary, strArticle);
//        Article article6 = new Article(journalist6, "How TensorFlow is Powering Technology Around the World", "2018-05-09", CategoryType.AI, "/images/article-images/6.jpg", strSummary, strArticle);
//        Article article7 = new Article(journalist7, "Should Deep Learning Use Complex Numbers?", "2017-09-24", CategoryType.AI, "/images/article-images/7.jpg", strSummary, strArticle);
//        Article article8 = new Article(journalist8, "Deep Learning: Going Deeper toward Meaningful Patterns in Complex Data", "2018-02-12", CategoryType.AI, "/images/article-images/8.jpg", strSummary, strArticle);
//        Article article9 = new Article(journalist1, "A Brief History of Deep Learning", "2012-02-07", CategoryType.AI, "/images/article-images/9.jpg", strSummary, strArticle);
//        Article article10 = new Article(journalist10, "NASA: AI Will Lead the Future of Space Explortion", "2017-06-27", CategoryType.AI, "/images/article-images/10.jpg", strSummary, strArticle);
//        Article article11 = new Article(journalist11, "The Pivotal Role AI Plays in the Future of Space Travel", "2017-04-20", CategoryType.AI, "/images/article-images/11.jpg", strSummary, strArticle);
//        Article article12 = new Article(journalist12, "What Deep Blue Tells Us About AI in 2017", "2017-05-23", CategoryType.AI, "/images/article-images/12.jpg", strSummary, strArticle);
