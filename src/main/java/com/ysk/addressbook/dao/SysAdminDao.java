package com.ysk.addressbook.dao;

import com.ysk.addressbook.entity.SysAdmin;

/**
 * 描述
 * Created by Y.S.K on 2018/4/17 21:58
 */
public interface SysAdminDao {
  SysAdmin getByUserName(String username);
}
