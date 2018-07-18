package db;

import models.*;

import java.util.*;

public class Test {

    public static void seedData(){
        DBHelper.deleteAll(Rating.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        List<Journalist> journalists = new ArrayList<>();
        Journalist journalist1 = new Journalist("Joe Pollock", JournalismType.Broadcast);
        journalists.add(journalist1);
        DBHelper.save(journalist1);
        Journalist journalist2 = new Journalist("Angelina Blyth", JournalismType.Sport);
        journalists.add(journalist2);
        DBHelper.save(journalist2);
        Journalist journalist3 = new Journalist("John McCollum", JournalismType.Communication);
        journalists.add(journalist3);
        DBHelper.save(journalist3);
        Journalist journalist4 = new Journalist("Louise Reid", JournalismType.Freelance);
        journalists.add(journalist4);
        DBHelper.save(journalist4);
        Journalist journalist5 = new Journalist("Colin Bell", JournalismType.PR);
        journalists.add(journalist5);
        DBHelper.save(journalist5);
        Journalist journalist6 = new Journalist("Steve MJ", JournalismType.Investigative);
        journalists.add(journalist6);
        DBHelper.save(journalist6);

        String strArticle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum venenatis urna at libero scelerisque dignissim malesuada eget mi. Morbi eget nulla pharetra arcu tempus ullamcorper ac id nulla. Phasellus ante neque, feugiat eu volutpat sed, blandit nec leo. Etiam luctus nulla velit, sed ullamcorper leo ultricies lobortis. Cras rhoncus fermentum nulla at faucibus. Praesent sodales neque in lorem commodo, eget imperdiet lectus congue. Duis quis turpis turpis. Nam eleifend at leo fringilla rhoncus.\n" +
                "\n\n" +
                "Suspendisse imperdiet, tellus in bibendum pellentesque, tortor lacus imperdiet dolor, vel facilisis libero massa sodales metus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus in finibus risus, vel maximus mi. Etiam magna leo, mollis in nisi sed, elementum mollis risus. Donec suscipit nibh tristique egestas placerat. In auctor quam rhoncus, tempus velit et, vulputate magna. Fusce ornare neque et odio lacinia aliquet. Curabitur volutpat justo eu egestas elementum. Morbi volutpat sagittis dignissim. Donec risus sapien, tincidunt eu magna a, tempus laoreet tellus. Donec quis pulvinar metus. Nulla facilisi.\n" +
                "\n\n" +
                "Praesent consectetur velit odio. Donec tempor aliquam elit quis rhoncus. Etiam vel ex pulvinar mi porta ultricies in nec augue. Maecenas facilisis ex id quam vestibulum, eu elementum nulla viverra. Maecenas felis nunc, cursus eget velit id, congue vehicula leo. Etiam nulla mi, viverra euismod mauris sed, feugiat condimentum quam. Cras ullamcorper vitae tortor quis fringilla. Integer justo orci, accumsan eget dignissim a, mollis vitae tortor. Quisque libero dolor, tempor sit amet enim et, blandit dictum ipsum. Praesent in vestibulum odio, non fringilla ante. Maecenas posuere ullamcorper nisi, sed ullamcorper ante mollis ut. In varius accumsan consequat. Donec tristique augue id vestibulum congue. Ut sit amet gravida elit.\n" +
                "\n\n" +
                "Nullam ac commodo nisl. Suspendisse et urna est. Sed sit amet ante massa. Aenean eu ex auctor, egestas elit sit amet, feugiat augue. Maecenas ornare, ipsum a fermentum aliquam, velit purus dictum nulla, eget lobortis urna leo quis augue. Nam et orci mattis, euismod sem at, semper tortor. Vestibulum quis lacinia massa, non rhoncus sem. Sed odio sem, ultrices non eleifend sed, imperdiet non libero. Suspendisse quis tincidunt purus. Quisque convallis a diam a vulputate. Nulla id est sed leo tempus viverra. Proin pulvinar nulla at augue hendrerit laoreet. Sed a rhoncus magna. Mauris nisl ipsum, rutrum eu eleifend sit amet, auctor ac nibh. Duis tortor tellus, imperdiet congue turpis in, fringilla molestie elit. Cras iaculis, dolor ultricies viverra luctus, magna ligula suscipit magna, ut iaculis est tellus sollicitudin ligula.\n" +
                "\n\n" +
                "Pellentesque porta in sem sit amet rutrum. Sed fermentum, nulla sed dictum tincidunt, massa massa posuere enim, id rutrum mauris tellus quis dui. Fusce tellus eros, tempus eu tellus vitae, convallis varius ante. Phasellus turpis odio, condimentum et augue at, tempor luctus elit. Nam at tincidunt sapien, vitae semper urna. Aliquam viverra mi ex. Duis fermentum ipsum et sollicitudin dapibus. Fusce sed purus urna.";

        HashMap<String, String> titleImage = new HashMap<String, String>();
        titleImage.put("Military Tracking System Disappears", "1.jpg");
        titleImage.put("Man Accused of Killing Lawyer Receives New Attorney", "2.png");
        titleImage.put("Mayor Thomson Speaks to Homeless: Go Home", "3.jpeg");
        titleImage.put("Homicide Victims Rarely Talk to Police", "4.jpg");
        titleImage.put("Poison Control Centre Expert Reminds Everyone Not to Take Poison", "5.jpg");
        titleImage.put("Most Earthquake Damage is Caused by Shaking", "6.jpg");
        titleImage.put("Federal Agents Raid Gun Shop, Find Weapons", "7.jpg");
        titleImage.put("Teen Pregnancy Drops Significantly after 25", "8.gif");
        titleImage.put("Prisons to Replace Easy-Open Locks", "9.jpg");
        titleImage.put("Body Found in Cemetery", "10.jpeg");
        titleImage.put("Parents Keep Kids Home to Protest School Closure", "11.jpeg");
        titleImage.put("17 Remain Dead in Morgue Shooting Spree", "12.JPG");
        titleImage.put("Threat Disrupts Plans to Meet About Threats", "13.jpg");
        titleImage.put("Midget Sues Grocer, Cites Belittling Remarks", "14.jpg");
        titleImage.put("Police Thwarted by Goat Stuck on Roof who 'only respects one man'", "15.jpg");
        titleImage.put("Diana was still alive hours before she died", "16.gif");
        titleImage.put("One-Armed Man Applauds the Kindness of Strangers", "17.jpg");
        titleImage.put("Plane Forced to Land at Airport", "18.jpg");
        titleImage.put("Police Team Heroically Ends 6 Hour Standoff with Empty Apartment", "19.jpg");

        for (String key : titleImage.keySet()) {
            String title = key;
            String imagePath = "/images/article-images/" + titleImage.get(key);
            Random t = new Random();
            Journalist journalist = journalists.get(t.nextInt(journalists.size()-0) + 0);

            Article article = new Article(journalist, title, getRandomDate(), CategoryType.World, imagePath, "This is summary test.", strArticle);
            Random d = new Random(); int hits = d.nextInt(250-50) + 50; article.setArticleHits(hits);
            DBHelper.save(article);
            applyRandomRating(article);
        }
    }

    private static String getRandomDate(){
        Random y = new Random();
        Random m = new Random();
        Random d = new Random();
        int year = y.nextInt(2018-2005) + 2005;
        String strYear = String.valueOf(year);
        int month = m.nextInt(12-1) + 1;
        String strMonth = String.valueOf(month);
        if(strMonth.length() == 1){ strMonth = "0" + strMonth; }
        int day = d.nextInt(28-1) + 1;
        String strDay = String.valueOf(day);
        if(strDay.length() == 1){ strDay = "0" + strDay; }
        String date = strYear + "-" + strMonth + "-" + strDay;
        return date;
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
