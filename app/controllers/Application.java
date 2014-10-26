package controllers;

import play.*;
import models.InsuranceRegion;
import play.mvc.*;

import views.html.*;

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

}
