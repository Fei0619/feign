package com.test.ib.web.share;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 费世程
 * @date 2019/8/14 14:27
 */
public class ExceptionUtils {
  private ExceptionUtils() {
  }

  /**
   * 获取异常栈信息
   *
   * @param t 异常信息
   * @return 异常栈
   */
  public static String getThrowableTrace(Throwable t) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw, true);
    t.printStackTrace(pw);
    pw.flush();
    sw.flush();
    return sw.toString();
  }
}