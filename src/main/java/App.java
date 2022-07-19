import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.lang.reflect.Array;
import java.util.*;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home", (request, response) -> {
            return new ModelAndView(request.session().attribute("mySquadArrayList"), "list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero_form", (request, response) -> {
            return new ModelAndView(new HashMap(), "hero_form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad_form", (request, response) -> {
            return new ModelAndView(new HashMap(), "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/add_form", (request, response) -> {
            request.session();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String size = request.queryParams("number");
            Integer intSize = Integer.parseInt(size);
            Squad newSquad = new Squad(name,cause,intSize);
            ArrayList mySquadArrayList = newSquad.getAll();
            Map<Object, ArrayList<Squad>> model = new HashMap<>();
            request.session().attribute("mySquadArrayList", mySquadArrayList);
            model.put("mySquads",mySquadArrayList);
            return new ModelAndView(model, "list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home/:id", (request, response) -> {
            String id = request.params(":id");
            Integer intId = Integer.parseInt(id);

            ArrayList mySquadArrayList = request.session().attribute("mySquadArrayList");

            Squad oneSquad = (Squad) mySquadArrayList.get(intId-1);

            String squadName =oneSquad.getName();
            String squadCause = oneSquad.getCause();
            List squadMembers = oneSquad.getMembers();

            Map<Object, Object> model = new HashMap<>();
            model.put("mySquads",mySquadArrayList);
            model.put("name", squadName);
            model.put("cause", squadCause);
            model.put("members",squadMembers);

            return new ModelAndView(model, "list.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
