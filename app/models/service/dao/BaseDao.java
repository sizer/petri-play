package models.service.dao;

import models.entity.AbstractTrailModel;

import java.util.List;
import utils.OptionUtil;
import play.db.ebean.Model.Finder;
import static play.libs.F.*;
import lombok.Getter;

/**
 * CRUD処理のインターフェース
 */
public abstract class BaseDao<T extends AbstractTrailModel> {

  //TODO findのゲッターを削除。
  @Getter
  protected Finder<Long, T> find;

  //TODO アクセスレベルの見直し
  public Option<T> findById(Long id){
    return OptionUtil.apply(find.byId(id));
  }

  public Option<T> save(T entry){
    Option<T> entryOps = OptionUtil.apply(entry);
    if(entryOps.isDefined()) {
        entry.save();
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

}
