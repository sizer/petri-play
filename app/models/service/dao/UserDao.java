package models.service.dao;

import models.entity.User;
import play.db.ebean.Model.Finder;
import models.service.dao.BaseDao;

public class UserDao extends BaseDao<User> {

  private UserDao(){
    if(find == null) {
        super.find = new Finder<Long, User>(Long.class, User.class);
    }
  }

  public static UserDao use() {
      return new UserDao();
  }

  public User getUser(String name, String password){
    return find.where()
      .eq("name", name)
      .eq("password", password)
      .findUnique();
  }
}
