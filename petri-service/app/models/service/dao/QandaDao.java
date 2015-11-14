package models.service.dao;

import models.entity.Qanda;
import play.db.ebean.Model.Finder;
import models.service.dao.BaseDao;
import static play.libs.F.*;

public class QandaDao extends BaseDao<Qanda> {

  private QandaDao(){
    if(find == null) {
      super.find = new Finder<Long, Qanda>(Long.class, Qanda.class);
    }
  }

  public static QandaDao use() {
    return new QandaDao();
  }
}
