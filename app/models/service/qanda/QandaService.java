package models.service.qanda;

import java.util.List;
import models.service.dao.QandaDao;
import models.entity.Qanda;

public class QandaService {

  /**
   * isQuestion=1をキーに、QANDAリストを取得する
   */
  public static List<Qanda> getQuestions(){
  	return QandaDao.use().getFind().where().eq("isQuestion", 1).findList();
  }

  public static void insertQanda(Qanda entity){
    entity.isQuestion = 1;
    QandaDao.use().save(entity);
  }
}
