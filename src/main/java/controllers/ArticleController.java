package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController(){
        this.setupEndpoints();
    }

    public void setupEndpoints(){

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/articles", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Article> articles = DBHelper.getAll(Article.class);
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        get("/articles/new", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> allJournalists = DBHelper.getAll(Journalist.class);
            ArrayList<String> categories = new ArrayList<>();
            for (CategoryType cat : CategoryType.values()) {
                categories.add(cat.name());
            }
            model.put("categories", categories);
            model.put("allJournalists", allJournalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("articles/:id/edit", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            ArrayList<String> categories = new ArrayList<>();
            for (CategoryType cat : CategoryType.values()) {
                categories.add(cat.name());
            }
            model.put("article", article);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("template", "templates/articles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        post("/articles", (req, res) ->{
            String title = req.queryParams("title");

            // req.queryParams("category") is currently returning a String.
            // Uncomment this line when Angelina finds a way to pass the list
            // of enum values into a vtl file (should return CategoryType).
            //CategoryType category = req.queryParams("category");

            String publishDate = req.queryParams("publishDate");


            String imagePath = req.queryParams("imagePath");
            String summary = req.queryParams("summary");
            String fullArticle = req.queryParams("fullArticle");
            int journalist_id = Integer.parseInt(req.queryParams("journalist_id"));
            Journalist journalist = DBHelper.find(journalist_id, Journalist.class);

            Article article = new Article(journalist, title, publishDate, CategoryType.Industry, imagePath, summary, fullArticle);
            DBHelper.save(article);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);


        get("/articles/new", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


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
            article.setImagePath(imagePath);

            DBHelper.save(article);
            res.redirect("/articles");
            return null;

        }, velocityTemplateEngine);


        get("articles/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", article);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        post("/articles/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Article articleToDelete = DBHelper.find(id, Article.class);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

    }
}
