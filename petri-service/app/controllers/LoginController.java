package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import static play.data.Form.form;
import models.LoginForm;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Security.Authenticated;
import views.html.*;
import views.html.login.*;
import models.service.cmn.PetriAuthenticator;

public class LoginController extends Controller {

  @AddCSRFToken
  public static Result index(){
    return ok(login.render(form(LoginForm.class)));
  }

  @RequireCSRFCheck
  public static Result login() {
    Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
    if(loginForm.hasErrors()){
      return badRequest(login.render(loginForm));
    } else {
      session("loginUser", loginForm.get().getName());
      String returnUrl = ctx().session().get("returnUrl");
      if(returnUrl == null
          || returnUrl.equals("")
          || returnUrl.equals(routes.LoginController.index().absoluteURL(request()))){
            returnUrl = routes.QandaController.index().url();
      }
      return redirect(returnUrl);
    }
  }

  @Authenticated(PetriAuthenticator.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.LoginController.index());
  }

}
