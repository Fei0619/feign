package com.test.ib.web.pojo.tb;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 费世程
 * @date 2019/8/14 15:03
 */
@Data
public class IbSubject {

  private Integer subjectId;

  private String subjectName;

  public String toString() {
      return JSON.toJSONString(this);
  }

}
