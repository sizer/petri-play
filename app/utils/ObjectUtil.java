package utils;

import java.lang.reflect.Field;

public class ObjectUtil {
  /**
   * 引数のインスタンスのフィールドを取得し、標準出力する。
   */
  public static void getFields(Object arg){
    StringBuilder sb = new StringBuilder();
    sb.append("Class: " + arg.getClass().getCanonicalName() + "\n");
    sb.append("Settings:\n");
    for (Field field : arg.getClass().getDeclaredFields()) {
        try {
            field.setAccessible(true);
            sb.append(field.getName() + " = " + field.get(arg) + "\n");
        } catch (IllegalAccessException e) {
            sb.append(field.getName() + " = " + "access denied\n");
        }
    }
  }
}
