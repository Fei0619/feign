package com.test.ib.web.dao;

import com.test.ib.web.pojo.UserGradeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 15:11
 */
@Repository
public interface IbUserSubjectDao {

  /**
   * 获取某个用户的成绩
   * @param userId
   * @return com.test.ib.web.pojo.UserGradeInfo
   * @author 费世程
   * @date 2019/8/14 15:12
   */
  UserGradeInfo getUserGrade(@Param(value = "userId") Integer userId);

}
