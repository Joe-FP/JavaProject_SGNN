package controllers;
import db.DBHelper;
import models.Article;
import models.CategoryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Support {

    // Returns an ArrayList of categories which contain articles.
    // Empty categories not returned.
    public static ArrayList<String> getActiveCategories(List<Article> articles){
        ArrayList<String> categories = new ArrayList<>();
        for (Article article : articles) {
            if(!categories.contains(article.getCategoryType().name())){
                categories.add(article.getCategoryType().name());
            }
        }
        Collections.sort(categories);
        return categories;
    }

    // Returns an ArrayList of all available categories.
    public static ArrayList<String> getAllCategories(){
        ArrayList<String> categories = new ArrayList<>();
        for (CategoryType cat : CategoryType.values()) {
            categories.add(cat.name());
        }
        return categories;
    }

//            SimpleDateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
//            Date date;
//            try {
//                date = parser.parse(publishD);
//            } catch (ParseException e) {
//                date = null;
//                e.printStackTrace();
//            }
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//            String formattedDate = formatter.format(date);

}
