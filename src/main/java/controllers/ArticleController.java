package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
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

        //View all articles
        get("/articles", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Article> articles = DBHelper.getAll(Article.class);
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        //New Article
        get("/articles/new", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> allJournalists = DBHelper.getAll(Journalist.class);
            model.put("allJournalists", allJournalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/articles", (req, res) ->{
            String title = req.queryParams("title");

            // req.queryParams("category") is currently returning a String.
            // Uncomment this line when Angelina finds a way to pass the list
            // of enum values into a vtl file (should return CategoryType).
            //CategoryType category = req.queryParams("category");

            String imagePath = req.queryParams("imagePath");
            String summary = req.queryParams("summary");
            String fullArticle = req.queryParams("fullArticle");
            int journalist_id = Integer.parseInt(req.queryParams("journalist_id"));
            Journalist journalist = DBHelper.find(journalist_id, Journalist.class);

            Article article = new Article(journalist, title, CategoryType.INDUSTRY, imagePath, summary, fullArticle);
            DBHelper.save(article);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

    }
}
