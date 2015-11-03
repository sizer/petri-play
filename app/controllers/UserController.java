package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Security.Authenticated;
import models.entity.User;
import models.service.dao.UserDao;
import models.service.cmn.PetriAuthenticator;
import views.html.user.*;

@Authenticated(PetriAuthenticator.class)
public class UserController extends Controller{
  private static UserDao dao = UserDao.use();

  public static Result index(){
    return null;
  }

  public static Result create(){
    return null;
  }

  public static Result insert(){
    return null;
  }

  public static Result show(Long id){
    User entity = dao.findById(id).get();
    return ok(user.render(entity));
  }

  public static Result edit(Long id){
    return null;
  }

  public static Result update(Long id){
    return null;
  }

  public static Result delete(Long id){
    return null;
  }
}
