package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/articles", (req, res) ->{
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(journalistId, Journalist.class);

            String title = req.queryParams("title");

            String typeString = req.queryParams("categoryType");
            CategoryType categoryType = CategoryType.valueOf(typeString);

            String imagePath = req.queryParams("imagePath");
            String articleSummary = req.queryParams("articleSummary");
            String fullArticle = req.queryParams("fullArticle");

            Article newArticle = new Article(journalist, title, categoryType, imagePath, articleSummary, fullArticle);
            DBHelper.save(newArticle);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);



        //View individual article

        get("articles/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", article);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        //Edit Article

        get("articles/:id/edit", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);

            Article article = DBHelper.find(intId, Article.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);

            HashMap<String, Object> model = new HashMap<>();
            model.put("article", article);
            model.put("journalists", journalists);

            model.put("template", "templates/articles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/articless/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);

            int journalistID = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(journalistID, Journalist.class);


            String title = req.queryParams("title");
            String typeString = req.queryParams("categoryType");
            CategoryType categoryType = CategoryType.valueOf(typeString);
            String imagePath = req.queryParams("imagePath");
            String articleSummary = req.queryParams("articleSummary");
            String fullArticle = req.queryParams("fullArticle");

            article.setJournalist(journalist);
            article.setTitle(title);
            article.setCategoryType(categoryType);
            article.setImagePath(imagePath);
            article.setArticleSummary(articleSummary);
            article.setFullArticle(fullArticle);

            DBHelper.save(article);
            res.redirect("articles/:id");
            return null;
        }, velocityTemplateEngine);


        //Delete Article

        post("/articles/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Article articleToDelete = DBHelper.find(id, Article.class);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);





    }
}
