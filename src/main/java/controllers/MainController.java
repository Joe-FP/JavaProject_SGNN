package controllers;

import db.Seeds;
import db.Test;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;
import static spark.route.HttpMethod.get;

public class MainController {

    public static void main(String[] args) {

        Test.seedData();
        staticFileLocation("/public");
        JournalistController journalistController = new JournalistController();
        ArticleController articleController = new ArticleController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
