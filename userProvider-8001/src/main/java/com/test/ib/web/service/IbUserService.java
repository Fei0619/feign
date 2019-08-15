package com.test.ib.web.service;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.share.Result;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 14:19
 */
public interface IbUserService {

  /**
   * 获取所有用户
   * @param
   * @return com.test.ib.web.share.Result<java.util.List < com.test.ib.web.pojo.IbUser>>
   * @author 费世程
   * @date 2019/8/14 14:29
   */
  Result<List<IbUser>> listAllUser();

  /**
   * 获取某一用户成绩
   * @param userId
   * @return com.test.ib.web.share.Result<com.test.ib.web.pojo.UserGradeInfo>
   * @author 费世程
   * @date 2019/8/14 16:30
   */
  Result<UserGradeInfo> getUserGrade(Integer userId);

}
