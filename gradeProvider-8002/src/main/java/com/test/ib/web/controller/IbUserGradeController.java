package com.test.ib.web.controller;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.service.IbUserGradeService;
import com.test.ib.web.share.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author 费世程
 * @date 2019/8/14 15:28
 */
@RestController
@RequestMapping(value = "/grade")
public class IbUserGradeController {

  private final IbUserGradeService userGradeService;

  @Autowired
  public IbUserGradeController(IbUserGradeService userGradeService){
    this.userGradeService=userGradeService;
  }

  @GetMapping(value = "/getOfUser")
  public Result<UserGradeInfo> getUserGrade(@PathParam(value = "userId") Integer userId) {
    return userGradeService.getUserGrade(userId);
  }

}
