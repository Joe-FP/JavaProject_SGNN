package controllers;

import db.DBHelper;
import models.JournalismType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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
        get("/journalist/add", (req, res) ->{
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/journalist/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/journalists", (req, res) ->{
            String name = req.queryParams("name");
            String type = req.queryParams("journalismType");
            JournalismType journalismType = JournalismType.getValue(type);
            Journalist newJournalist = new Journalist(name, type);
            DBHelper.save(newJournalist);
            res.redirect("/journalists");
            return null;
        }, velocityTemplateEngine);

        //Show an individual Journalist

        get("journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        //Edit current Journalist

        get("journalists/:id/edit", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);

            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("template", "templates/journalist/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);

            String name = req.queryParams("name");
            String type = req.queryParams("journalismType");

            journalist.setName(name);
            journalist.setJournalismType(type);

            DBHelper.save(journalist);
            res.redirect("journalist/:id");
            return null;
        }, velocityTemplateEngine);

        //Delete the current Journalist

        post("/journalists/:id/delete", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalistToDelete = DBHelper.find(intId, Journalist.class);
            DBHelper.delete(journalistToDelete);
            res.redirect("/journalists");
            return null;
        }, velocityTemplateEngine);
    }
}
