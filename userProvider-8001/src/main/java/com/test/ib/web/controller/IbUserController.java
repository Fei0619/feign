package com.test.ib.web.controller;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.service.IbUserService;
import com.test.ib.web.share.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 14:29
 */
@RestController
@RequestMapping(value = "/user")
public class IbUserController {

  private final IbUserService userService;

  @Autowired
  public IbUserController(IbUserService userService){
    this.userService=userService;
  }

  @GetMapping(value = "/listAll")
  public Result<List<IbUser>> listAllUser() {
    return userService.listAllUser();
  }

  @GetMapping(value = "/feign/getUserGrade")
  public Result<UserGradeInfo> getUserGrade(@RequestParam(value = "userId") Integer userId) {
    return userService.getUserGrade(userId);
  }


}
