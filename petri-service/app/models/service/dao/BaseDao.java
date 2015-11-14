package models.service.dao;

import models.entity.AbstractTrailModel;

import java.util.List;
import utils.OptionUtil;
import play.db.ebean.Model.Finder;
import static play.libs.F.*;
import lombok.Getter;
import utils.DateUtil;
import models.entity.User;

/**
 * CRUD処理のインターフェース
 */
public abstract class BaseDao<T extends AbstractTrailModel> {

  /**
   * <pre>
   * code of save type.
   * </pre>
   */
  public static final int INSERT = 1;
  public static final int UPDATE = 2;
  public static final int DELETE = 3;

  //TODO findのゲッターを削除。
  @Getter
  protected Finder<Long, T> find;

  /**
   * <pre>
   * find an model by id.
   * for its return value is Option type,
   * when want to get value Option.get() method.
   * </pre>
   * @param  id of model
   * @return    result of searching
   */
   //TODO アクセスレベルをprotectedにできないか検討する。
  public Option<T> findById(Long id){
    return OptionUtil.apply(find.byId(id));
  }

  /**
   * <pre>
   * persist entity
   * </pre>
   * @param  entry target entity of saving
   * @return       result entity of saveing
   */
  public Option<T> save(T entry){
    Option<T> entryOps = OptionUtil.apply(entry);
    if(entryOps.isDefined()) {
        exeSave(entry);
        if(OptionUtil.apply(entry.id).isDefined()) {
            return OptionUtil.apply(entry);
        }
    }
    return new None<T>();
  }

  protected Option<T> delete(Long id){
    return null;
  }

  protected Option<T> deleteAll(List<Long> idList){
    return null;
  }

  /**
   * 保存処理
   */
  private void exeSave(AbstractTrailModel entity){
    if(entity.create_time != null){
      setTrailInfo(entity, UPDATE);
      entity.save();

    }else{
      setTrailInfo(entity, INSERT);
      entity.save();
    }
  }

  /**
   * <pre>
   * 追跡情報をセットする。
   * 設定されるカラム...create_time/create_user_id.update_time/update_user_id
   * </pre>
   */
  private void setTrailInfo(AbstractTrailModel entity, int code){

    switch(code) {
      case INSERT:
        entity.create_time = DateUtil.now();
        entity.createUser = User.getLoginUser();
      case UPDATE:
      case DELETE:
        entity.update_time = DateUtil.now();
        entity.updateUser = User.getLoginUser();
    }

    if(code == DELETE){
      entity.is_delete = 1;

    }else{
      entity.is_delete = 0;
    }
  }

}
