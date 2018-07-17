package db;

import models.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void seedData(){
        DBHelper.deleteAll(Rating.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        for (int i = 0; i <= 18; i++){
            Article article = new Article(getRandomJournalist(), getRandomTitle(), getRandomDate(), CategoryType.getRandomType(), getRandomImagePath(), "This is summary test.", "This is the full article");
            DBHelper.save(article);
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

    private static String getRandomTitle(){
        Random t = new Random();
        List<String> articleTitles = new ArrayList<>();
        articleTitles.add("Military Tracking System Disappears");
        articleTitles.add("Man Accused of Killing Lawyer Receives New Attorney");
        articleTitles.add("Mayor Thomson Speaks to Homeless: Go Home");
        articleTitles.add("Homicide Victims Rarely Talk to Police");
        articleTitles.add("Poison Control Centre Expert Reminds Everyone Not to Take Poison");
        articleTitles.add("Most Earthquake Damage is Caused by Shaking");
        articleTitles.add("Federal Agents Raid Gun Shop, Find Weapons");
        articleTitles.add("Teen Pregnancy Drops Significantly after 19");
        articleTitles.add("Prisons to Replace Easy-Open Locks");
        articleTitles.add("Body Found in Cemetery");
        articleTitles.add("Parents Keep Kids Home to Protest School Closure");
        articleTitles.add("17 Remain Dead in Morgue Shooting Spree");
        articleTitles.add("Threat Disrupts Plans to Meet About Threats");
        articleTitles.add("Midget Sues Grocer, Sites Belittling Remarks");
        articleTitles.add("Police Thwarted by Goat Stuck on Roof who 'only respects one man'");
        articleTitles.add("Diana was still alive hours before she died");
        articleTitles.add("One-Armed Man Applauds the Kindness of Strangers");
        articleTitles.add("Plane Forced to Land at Airport");
        articleTitles.add("Police Team Heroically Ends 6 Hour Standoff with Empty Apartment");
        return articleTitles.get(t.nextInt(articleTitles.size()-0) + 0);
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
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        imagePaths.add("/images/1.jpg");
        String path = imagePaths.get(p.nextInt(imagePaths.size()-0) + 0);
        return path;
    }

}
