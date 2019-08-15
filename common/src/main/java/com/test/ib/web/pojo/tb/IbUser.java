package com.test.ib.web.pojo.tb;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 费世程
 * @date 2019/8/14 10:17
 */
@Data
public class IbUser {

  private Integer userId;

  private String account;

  private String password;

  private String userName;

  private String sex;

  public String toString() {
      return JSON.toJSONString(this);
  }

}
