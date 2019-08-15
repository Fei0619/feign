package com.test.ib.web.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author 费世程
 * @date 2019/8/14 15:59
 */
@Data
public class SubjectGrade {

  private String subjectName;

  private Integer grade;

  public String toString() {
      return JSON.toJSONString(this);
  }
}
