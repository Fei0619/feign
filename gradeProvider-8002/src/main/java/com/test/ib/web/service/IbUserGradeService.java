package com.test.ib.web.service;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.share.Result;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 15:27
 */
public interface IbUserGradeService {

  /**
   * 获取某个用户的成绩
   * @param userId
   * @return com.test.ib.web.share.Result<com.test.ib.web.pojo.UserGradeInfo>
   * @author 费世程
   * @date 2019/8/14 15:29
   */
  Result<UserGradeInfo> getUserGrade(Integer userId);

  /**
   * 获取所有用户
   * @param
   * @return com.test.ib.web.share.Result<java.util.List < com.test.ib.web.pojo.tb.IbUser>>
   * @author 费世程
   * @date 2019/8/15 16:15
   */
  Result<List<IbUser>> listAllUser();

}
