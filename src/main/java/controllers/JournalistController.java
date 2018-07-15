package controllers;

import db.DBHelper;
import models.Article;
import models.JournalismType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

       //Add journalist
        get ("/journalists/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/journalists", (req, res) ->{
            String name = req.queryParams("name");
            String type = req.queryParams("journalismType");
            JournalismType journalismType = JournalismType.valueOf(type);
            Journalist newJournalist = new Journalist(name, journalismType);
            DBHelper.save(newJournalist);
            res.redirect("/journalists");
            return null;
        }, velocityTemplateEngine);

        //Show individual journalist
        get("journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            List<Article> articles = DBHelper.getAllArticlesWrittenByJournalist(journalist);
            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("articles", articles);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

       //Edit journalist


        get("journalists/:id/edit", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);

            HashMap<String, Object> model = new HashMap<>();
            model.put("journalists", journalist);

            model.put("template", "templates/journalists/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);

            String name = req.queryParams("name");
            String type = req.queryParams("journalismType");

            journalist.setName(name);
            //journalist.setJournalismType(type);

            DBHelper.save(journalist);
            res.redirect("journalists/:id");
            return null;
        }, velocityTemplateEngine);

       //Delete journalist
        post("/journalists/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalistToDelete = DBHelper.find(id, Journalist.class);
            DBHelper.delete(journalistToDelete);
            res.redirect("/journalists");
            return null;
        }, velocityTemplateEngine);

    }
}
