import models.Hero;
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
            return new ModelAndView(new HashMap(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/", (request, response) -> {
            return new ModelAndView(request.session().attribute("mySquadArrayList"), "list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero_form", (request, response) -> {
            ArrayList mySquadArrayList = request.session().attribute("mySquadArrayList");
            Map<Object, Object> model = new HashMap<>();
            model.put("mySquads",mySquadArrayList);
            return new ModelAndView(model, "hero_form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad_form", (request, response) -> {
            return new ModelAndView(new HashMap(), "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/add_squad", (request, response) -> {
            request.session();
            Map<Object, Object> model = new HashMap<>();
            try{
                String name = request.queryParams("name");
                String cause = request.queryParams("cause");
                String size = request.queryParams("number");
                Integer intSize = Integer.parseInt(size);
                Squad newSquad = new Squad(name,cause,intSize);
                ArrayList mySquadArrayList = newSquad.getAll();
                request.session().attribute("mySquadArrayList", mySquadArrayList);
                model.put("mySquads",mySquadArrayList);
                return new ModelAndView(model, "list.hbs");
            }catch (Exception exception) {
                model.put("myError",exception);
                return new ModelAndView(model,"/squad_form.hbs");
            }

        }, new HandlebarsTemplateEngine());

        get("/squad/:id", (request, response) -> {
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

        post("/add_hero",(request,response)->{
            ArrayList mySquadArrayList = request.session().attribute("mySquadArrayList");
            Map<Object, Object> model = new HashMap<>();
            try{
                String name = request.queryParams("name");
                String age = request.queryParams("age");
                String power = request.queryParams("power");
                String weakness = request.queryParams("weakness");
                String id = request.queryParams("id");
                Integer intAge = Integer.parseInt(age);
                Integer intId = Integer.parseInt(id);

                Hero newHero = new Hero(name,intAge,power,weakness);
                for(Object mySquad:mySquadArrayList) {
                    if(((Squad) mySquad).getId()==intId){
                        try {
                            ((Squad) mySquad).addHero(newHero);
                        }catch (UnsupportedOperationException exception) {
                            model.put("myError",exception);
                            return new ModelAndView(model,"/hero_form.hbs");
                        }
                    };
                }
                model.put("mySquads",mySquadArrayList);
                return new ModelAndView(model,"list.hbs");
            }catch (Exception exception) {
                model.put("myError",exception);
                return new ModelAndView(model,"/hero_form.hbs");
            }


        },new HandlebarsTemplateEngine());

    }
}
