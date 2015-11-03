package models.service.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import models.entity.User;

public class UserDao extends BaseDao {

	private static final long serialVersionUID = 1L;

	public User findUser(String name, String pass) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);

		Root<User> root = query.from(User.class);
		query.where(cb.lessThan(root.get("name"), name));

		TypedQuery<User> q = createQuery(query);
		return executeTypedQuery(q);
	}
}
