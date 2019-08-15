package com.test.ib.web.dao;

import com.test.ib.web.pojo.tb.IbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 费世程
 * @date 2019/8/14 10:50
 */
@Repository
public interface IbUserDao {

  /**
   * 获取所有用户
   * @param
   * @return java.util.List<com.test.ib.web.pojo.IbUser>
   * @author 费世程
   * @date 2019/8/14 10:53
   */
  List<IbUser> listAllUser();

}
