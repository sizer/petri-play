package utils;

import play.db.ebean.Model;

/**
 * モデル用ユーティリティクラス
 */
public class ModelUtil {

  /**
   * 引数のクラスのFinderを取得する
   * @param  clazz Finderを取得するクラス
   * @return       引数のクラスのFinder
   */
  public static <T extends Model> Model.Finder<Long, T> getFinder(Class<T> clazz) {
      return new Model.Finder<Long, T>(Long.class, clazz);
  }
}
