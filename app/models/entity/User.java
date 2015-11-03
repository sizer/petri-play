package models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import models.service.dao.UserDao;
import play.data.validation.Constraints;
import play.mvc.Http.Context;

/**
 * User entity managed by Ebean
 */
@Entity
public class User extends AbstractTrailEntity {

	private static UserDao dao = new UserDao();

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	@Constraints.Required
	public String name;
	@Constraints.Required
	public String password;
	@Constraints.Required
	public Integer is_active;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createUser")
	public List<Evaluation> evaluations = new ArrayList<Evaluation>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createUser")
	public List<Qanda> qandas = new ArrayList<Qanda>();
	@ManyToMany
	public List<Roll> rolls = new ArrayList<Roll>();

	public static String getUserName(Long id) {
		return dao.findByPK(User.class, id).name;
	}

	public Integer getQuestionSize() {
		int count = 0;
		for (Qanda q : qandas) {
			if (q.isQuestion == 1) {
				count++;
			}
		}
		return count;
	}

	public Integer getAnswerSize() {
		int count = 0;
		for (Qanda q : qandas) {
			if (q.isQuestion == 0) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 現在ログインしているユーザーのentityをセッションから取得する
	 * 
	 * @return ログインユーザーのentity
	 */
	public static User getLoginUser() {
		User retUser = null;
		List<User> uList = dao.findAll(User.class);
		for (User u : uList) {
			if (u.name.equals(Context.current().session().get("loginUser"))) {
				retUser = u;
			}
		}
		return retUser;
	}

	public static User createTestUser() {
		return dao.findByPK(User.class, 1L);
	}
}
