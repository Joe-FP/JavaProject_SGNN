package db;

import models.*;

import java.util.*;

public class Test {

    public static void seedData(){
        DBHelper.deleteAll(Rating.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

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
        titleImage.put("Midget Sues Grocer, Sites Belittling Remarks", "14.jpg");
        titleImage.put("Police Thwarted by Goat Stuck on Roof who 'only respects one man'", "15.jpg");
        titleImage.put("Diana was still alive hours before she died", "16.gif");
        titleImage.put("One-Armed Man Applauds the Kindness of Strangers", "17.jpg");
        titleImage.put("Plane Forced to Land at Airport", "18.jpg");
        titleImage.put("Police Team Heroically Ends 6 Hour Standoff with Empty Apartment", "19.jpg");

        for (String key : titleImage.keySet()) {
            String title = key;
            String imagePath = "/images/article-images/" + titleImage.get(key);
            Article article = new Article(getRandomJournalist(), title, getRandomDate(), CategoryType.getRandomType(), imagePath, "This is summary test.", "This is the full article");
            Random d = new Random(); int hits = d.nextInt(250-50) + 50; article.setArticleHits(hits);
            DBHelper.save(article);
            applyRandomRating(article);
        }
    }

    private static Journalist getRandomJournalist(){
        Random t = new Random();
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
        return journalists.get(t.nextInt(journalists.size()-0) + 0);
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
        if(strDay.length() == 1){ strDay = "0" + strMonth; }
        String date = strYear + "-" + strMonth + "-" + strDay;
        return date;
    }

    private static String getRandomImagePath(){
        Random p = new Random();
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add("/images/article-images/6.jpg");
        String path = imagePaths.get(p.nextInt(imagePaths.size()-0) + 0);
        return path;
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
