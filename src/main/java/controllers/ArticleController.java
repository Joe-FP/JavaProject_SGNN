package controllers;


import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import models.Rating;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

import static spark.route.HttpMethod.get;

public class ArticleController {

    public ArticleController(){
        this.setupEndpoints();
    }

    public void setupEndpoints(){

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        // display all articles
        get("/articles", (req, res) ->{
            List<Article> articles = DBHelper.orderByPublishDate();
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getActiveCategories(articles);
            // Put variables into model.
            HashMap<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        // display all articles - ordered by date
        get("/articles/bydate", (req, res) ->{
            List<Article> articles = DBHelper.orderByPublishDate();
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getActiveCategories(articles);
            HashMap<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        // display all articles - ordered by hits (article views)
        get("/articles/byhits", (req, res) ->{
            List<Article> articles = DBHelper.orderByArticleHits();
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getActiveCategories(articles);
            HashMap<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        // display page to create a new article
        get("/articles/new", (req, res) ->{
            List<Journalist> allJournalists = DBHelper.getAll(Journalist.class);
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getAllCategories();
            HashMap<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("allJournalists", allJournalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        // display page to edit existing article
        get("articles/:id/edit", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.find(id, Article.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getAllCategories();
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", article);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("template", "templates/articles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        // update an existing article
        post("/articles", (req, res) ->{
            String title = req.queryParams("title");
            String publishDate = req.queryParams("publishD");
            String categoryType = req.queryParams("category");
            CategoryType category = CategoryType.valueOf(categoryType);
            String imagePath = "/images/article-images/" + req.queryParams("imagePath");
            String summary = req.queryParams("summary");
            String fullArticle = req.queryParams("fullArticle");
            int journalist_id = Integer.parseInt(req.queryParams("journalist_id"));
            Journalist journalist = DBHelper.find(journalist_id, Journalist.class);
            Article article = new Article(journalist, title, publishDate, category, imagePath, summary, fullArticle);
            DBHelper.save(article);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);


        //
        post("/articles/:id", (req, res) ->{
            //Get article id from url param
            int ArticleID = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.find(ArticleID, Article.class);
            //Get journalist from article
            int JournalistID = article.getJournalist().getId();
            Journalist journalist = DBHelper.find(JournalistID, Journalist.class);
            String title = req.queryParams("title");
            String publishD = req.queryParams("publishD");
            String categoryType = req.queryParams("category");
            CategoryType category = CategoryType.valueOf(categoryType);
            String articleSummary = req.queryParams("articleSummary");
            String fullArticle = req.queryParams("fullArticle");
            String imagePath = req.queryParams("imagePath");
            article.setJournalist(journalist);
            article.setTitle(title);
            article.setPublishD(publishD);
            article.setCategoryType(category);
            article.setArticleSummary(articleSummary);
            article.setFullArticle(fullArticle);
//            article.setImagePath(imagePath);
            DBHelper.save(article);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

        //
        get("articles/:id", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.find(id, Article.class);
            article.setArticleHits(article.getArticleHits()+1);
            DBHelper.save(article);
            Article articleNew = DBHelper.find(id, Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", articleNew);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

//        post("articles/:id/view", (req, res) ->{
//            int id = Integer.parseInt(req.params(":id"));
//            Article article = DBHelper.find(id, Article.class);
//            article.setArticleHits(article.getArticleHits()+1);
//            DBHelper.save(article);
//            Article articleNew = DBHelper.find(id, Article.class);
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("article", articleNew);
//            model.put("template", "templates/articles/show.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);

        //
        post("/articles/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Article articleToDelete = DBHelper.find(id, Article.class);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);


        //
        post("/search", (req, res) -> {
            String searchTerm = req.queryParams("search");
            List<Article> articles = DBHelper.articlesBySearchTerm(searchTerm);
            ArrayList<String> categories = new ArrayList<>();
            categories = Support.getActiveCategories(articles);
            HashMap<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/search/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);


        //Method to return rating
        post("/articles/:id/rating", (req,res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            String ratingStr = req.queryParams("rating");
            int ratingInt = Integer.parseInt(ratingStr);
            Rating rating = new Rating(article, ratingInt);
            DBHelper.save(rating);
            res.redirect("/articles/" + strId);
            return null;
        }, velocityTemplateEngine);

    }
}
