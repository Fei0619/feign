package com.test.ib.web.controller;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.service.IbUserGradeService;
import com.test.ib.web.share.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
  public Result<UserGradeInfo> getUserGrade(@RequestParam(value = "userId") Integer userId) {
    return userGradeService.getUserGrade(userId);
  }

  @GetMapping(value = "/feign/listAllUser")
  public Result<List<IbUser>> listAllUser() {
    return userGradeService.listAllUser();
  }

}
