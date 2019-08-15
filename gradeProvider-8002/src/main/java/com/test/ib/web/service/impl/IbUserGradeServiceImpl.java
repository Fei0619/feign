package com.test.ib.web.service.impl;

import com.test.ib.web.dao.IbUserSubjectDao;
import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.service.IbUserGradeService;
import com.test.ib.web.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 费世程
 * @date 2019/8/14 15:28
 */
@Service
@Slf4j
public class IbUserGradeServiceImpl implements IbUserGradeService {

  private final IbUserSubjectDao userSubjectDao;

  @Autowired
  public IbUserGradeServiceImpl(IbUserSubjectDao userSubjectDao){
    this.userSubjectDao=userSubjectDao;
  }

  @Override
  public Result<UserGradeInfo> getUserGrade(Integer userId) {
    if (userId==null){
      return Result.err("用户id为空！");
    }
    UserGradeInfo gradeInfo=userSubjectDao.getUserGrade(userId);
    return Result.ok(gradeInfo);
  }
}
