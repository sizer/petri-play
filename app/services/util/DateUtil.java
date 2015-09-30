package services.util;

import java.util.*;

public class DateUtil{

  /**
   * 引数の日付から経過した時間を算出し、"○○前"表記で返す。
   * @param  arg 日付
   * @return     引数の日付から経過した時間
   */
  public static String howLongFromNow(Date arg){
    String retStr;
    long diffTime = getSince(arg);

    long tmpTime = diffTime / 60000;
    if(tmpTime > 60){
      tmpTime /= 60;

      if(tmpTime > 24){
        tmpTime /= 24;

        if(tmpTime > 30){
          retStr = tmpTime / 30 +"月前";

        }else{
          retStr = tmpTime + "日前";

        }
      }else{
        retStr = tmpTime + "時間前";

      }
    }else{
      retStr = tmpTime + "分前";

    }
    return retStr;
  }

  /**
   * 引数の日付から経過した時間を算出し、Long型で返す。
   * @param  arg 日付
   * @return     引数の日付から経過した時間
   */
  public static long getSince(Date arg){
    return new Date(System.currentTimeMillis()).getTime() - arg.getTime();
  }
}
