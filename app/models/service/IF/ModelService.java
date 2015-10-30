package models.service.IF;

import play.db.ebean.Model;

import java.util.List;

import static play.libs.F.*;

/**
 * CRUD処理のインターフェース
 */
public interface ModelService<T extends Model> {

  public Option<T> findById(Long id);
  public Option<T> save(T entry);
  public Option<T> delete(Long id);
  public Option<T> deleteAll(List<Long> idList);

}
