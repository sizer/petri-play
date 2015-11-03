package controllers;

import models.entity.User;
import models.service.cmn.PetriAuthenticator;
import models.service.dao.UserDao;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.user.user;

@Authenticated(PetriAuthenticator.class)
public class UserController extends Controller {
	public static Result index() {
		return null;
	}

	public static Result create() {
		return null;
	}

	public static Result insert() {
		return null;
	}

	public static Result show(Long id) {
		User entity = new UserDao().findByPK(User.class, id);
		return ok(user.render(entity));
	}

	public static Result edit(Long id) {
		return null;
	}

	public static Result update(Long id) {
		return null;
	}

	public static Result delete(Long id) {
		return null;
	}
}
