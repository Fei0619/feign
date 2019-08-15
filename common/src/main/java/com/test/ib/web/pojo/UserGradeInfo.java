package com.test.ib.web.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 15:10
 */
@Data
public class UserGradeInfo {

  private String userName;

  List<SubjectGrade> gradeList;

  public String toString() {
      return JSON.toJSONString(this);
  }

}
