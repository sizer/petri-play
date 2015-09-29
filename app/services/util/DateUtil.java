package services.util;

import java.util.*;

public class DateUtil{
  public static String getSince(Date arg){
    String retStr;
    long diffTime = new Date(System.currentTimeMillis()).getTime() - arg.getTime();

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
}
