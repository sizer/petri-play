package models.service.cmn;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security.Authenticator;

public class PetriAuthenticator extends Authenticator {

  @Override
  public String getUsername(Context ctx){
    return ctx.session().get("loginUser");
  }

  @Override
  public Result onUnauthorized(Context ctx) {
    String returnUrl = ctx.request().uri();
    if(returnUrl == null){
      returnUrl = "/";
    }
    ctx.session().put("returnUrl", returnUrl);
    return redirect(controllers.routes.LoginController.index());
  }
}
