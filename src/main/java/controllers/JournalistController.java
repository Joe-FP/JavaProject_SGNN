package controllers;

import db.DBHelper;
import models.Article;
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


       //Show individual journalist
        get("journalists/:id", (req, res) ->{
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

       //Add journalist

       //Edit journalist

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
