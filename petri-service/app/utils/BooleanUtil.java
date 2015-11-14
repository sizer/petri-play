package utils;

public class BooleanUtil {

  /**
   * <pre>
   * 引数の数値型を真偽型に変換する
   * 引数の値が1の場合のみtrueとなり、それ以外はfalseとなる。
   * </pre>
   * @param  arg 変換元の数値
   * @return     返還後の値
   */
  public static boolean toBool(Integer arg){
    if(arg == null || arg != 1){
      return false;
    }
    return true;
  }
}
