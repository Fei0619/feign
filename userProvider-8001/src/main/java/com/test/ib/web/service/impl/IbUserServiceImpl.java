package com.test.ib.web.service.impl;

import com.test.ib.web.dao.IbUserDao;
import com.test.ib.web.feign.client.UserGradeClient;
import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.service.IbUserService;
import com.test.ib.web.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 14:20
 */
@Service
@Slf4j
public class IbUserServiceImpl implements IbUserService {

  private final IbUserDao userDao;
  private final UserGradeClient userGradeClient;

  @Autowired
  public IbUserServiceImpl(IbUserDao userDao,
                           UserGradeClient userGradeClient){
    this.userDao=userDao;
    this.userGradeClient=userGradeClient;
  }

  @Override
  public Result<List<IbUser>> listAllUser() {
    List<IbUser> list=userDao.listAllUser();
    return Result.ok(list);
  }

  @Override
  public Result<UserGradeInfo> getUserGrade(Integer userId) {
    return userGradeClient.getUserGrade(userId);
  }
}
