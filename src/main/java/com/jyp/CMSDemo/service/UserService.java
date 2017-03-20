package com.jyp.CMSDemo.service;


import com.jyp.CMSDemo.pojo.User;

import java.util.Set;

/**
 * Created by jyp on 2017/3/7.
 */

public interface UserService {
    /**
     * 根据username和password进行用户登录
     * @param username
     * @param password
     * @return 登录成功返回相应User，否则返回null
     */
    User login(String username, String password);

    /**
     * 根据username获取user
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 根据username获取该用户所有角色名
     * @param username
     * @return
     */
    Set<String> getRoles(String username) ;

    /**
     * 根据username获取该用户所有权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username) ;
}
