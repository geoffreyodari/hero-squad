import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero_form", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad_form", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
