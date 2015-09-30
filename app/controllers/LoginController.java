package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import views.html.login.*;
import services.SimpleAuthenticator;

public class LoginController extends Controller {

  public static class LoginForm{
    public String id;
    public String pass;
  }

  private static SimpleAuthenticator auth = new SimpleAuthenticator();

  public static Result index(){
    Form<LoginForm> loginForm = new Form(LoginForm.class);
    return ok(login.render("login form", loginForm));
  }

  public static Result login() {
    Form<LoginForm> f = new Form(LoginForm.class).bindFromRequest();
    LoginForm loginForm = f.get();

    if(f.hasErrors() || !auth.authenticate(loginForm.id, loginForm.pass)){
      return ok(login.render("login failed", f));
    }else{
      session("loginUser", loginForm.id);
      return ok(index.render("login success"));
    }
  }

  public static Result logout() {
    session().remove("loginUser");
    return ok(index.render("logout"));
  }

}
