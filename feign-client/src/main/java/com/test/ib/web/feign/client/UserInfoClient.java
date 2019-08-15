package com.test.ib.web.feign.client;


import com.test.ib.web.pojo.tb.IbUser;
import com.test.ib.web.share.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/15 15:45
 */
@FeignClient(value = "user-provider")
public interface UserInfoClient {

  @GetMapping(value = "/user/listAll")
  Result<List<IbUser>> listAllUser();


}
