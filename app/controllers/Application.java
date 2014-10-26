package controllers;

import play.*;
import models.InsuranceRegion;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addPage() {
        return ok(add.render());
    }

    public static Result addRegionRate() {
        InsuranceRegion region = Form.form(InsuranceRegion.class).bindFromRequest().get();
        region.save();
        return redirect(routes.Application.addPage());
    }

    public static Result listRates() {
        List<InsuranceRegion> rates = new Model.Finder(long.class, InsuranceRegion.class).all();
        return ok(toJson(rates));
    }

}
