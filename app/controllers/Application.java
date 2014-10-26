package controllers;

import models.InsuranceRegionId;
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

    public static Result maintenance() {
        return ok(maintenance.render());
    }

    public static Result addRegionRate() {
        InsuranceRegion region = Form.form(InsuranceRegion.class).bindFromRequest().get();
        region.save();
        return redirect(routes.Application.maintenance());
    }

    public static Result listRates() {
        List<InsuranceRegion> rates = new Model.Finder(InsuranceRegionId.class, InsuranceRegion.class).all();
        return ok(toJson(rates));
    }

    public static Result deleteRate(String id) {
        List<InsuranceRegion> regions = new Model.Finder(InsuranceRegionId.class, InsuranceRegion.class)
                .where()
                .eq("id", Integer.parseInt(id))
                .findList();
        if(regions.size() > 0) {
            regions.get(0).delete();
        }

        return redirect(routes.Application.maintenance());
    }
}
