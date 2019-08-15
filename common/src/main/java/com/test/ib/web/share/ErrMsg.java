package com.test.ib.web.share;

/**
 * @author 费世程
 * @date 2019/8/14 14:22
 */
public interface ErrMsg {

  /**
   * 响应状态码
   *
   * @return 响应状态码
   */
  int code();

  /**
   * 错误描述
   *
   * @return 错误描述
   */
  String desc();
}
