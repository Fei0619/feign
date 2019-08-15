package com.test.ib.web.feign.client;

import com.test.ib.web.pojo.UserGradeInfo;
import com.test.ib.web.share.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 费世程
 * @date 2019/8/14 15:46
 */
@FeignClient(value = "grade-provider")
public interface UserGradeClient {

  /**
   * 获取某一个用户的成绩
   * @param userId
   * @return com.test.ib.web.share.Result<com.test.ib.web.pojo.UserGradeInfo>
   * @author 费世程
   * @date 2019/8/14 16:09
   */
  @GetMapping(value = "/grade/getOfUser")
  Result<UserGradeInfo> getUserGrade(@RequestParam(value = "userId") Integer userId);

}
