package controllers;

import db.DBHelper;
import models.Article;
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


        //View individual article

        //Edit Article


        //Delete Article






    }
}
