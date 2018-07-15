package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.JournalismType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class JournalistController {


    public JournalistController(){
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        // Shows all Journalists
        get("/journalists", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("template", "templates/journalists/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        //Add a new Journalist
        get("/journalists/new", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            List<Article> articles = DBHelper.getAll(Article.class);
            ArrayList<String> categories = new ArrayList<>();
            for (JournalismType cat : JournalismType.values()) {
                categories.add(cat.name());
            }
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/journalists", (req, res) ->{
            String name = req.queryParams("name");
            String category = req.queryParams("category");
            JournalismType journalismType = JournalismType.valueOf(category);
            Journalist newJournalist = new Journalist(name, journalismType);
            DBHelper.save(newJournalist);
            res.redirect("/journalists");
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


        //Show an individual Journalist
        get("journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            List<Article> articles= DBHelper.getAllArticlesWrittenByJournalist(journalist);
            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("articles", articles);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        //Delete the current Journalist
        post("/journalists/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalistToDelete = DBHelper.find(id, Journalist.class);
            DBHelper.delete(journalistToDelete);
            res.redirect("/journalists");
            return null;
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


        //Edit current Journalist
        get("journalists/:id/edit", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            ArrayList<String> categories = new ArrayList<>();
            for (JournalismType cat : JournalismType.values()) {
                categories.add(cat.name());
            }
            model.put("journalist", journalist);
            model.put("categories", categories);
            model.put("template", "templates/journalists/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        post("/journalists/:id", (req, res) ->{
            Integer intId = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.find(intId, Journalist.class);

            String name = req.queryParams("name");
            String journalismType = req.queryParams("category");
            JournalismType category = JournalismType.valueOf(journalismType);

            journalist.setName(name);
            journalist.setJournalismType(category);
            DBHelper.save(journalist);
            res.redirect("/journalists");
            return null;
        }, velocityTemplateEngine);

    }
}
