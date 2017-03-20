package com.jyp.CMSDemo.dao;

import com.jyp.CMSDemo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jyp on 2017/3/7.
 */
@Service(value = "userDao")
public interface UserDao {
    /**
     * 根据id获取User
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 根据username获取User
     * @param username
     * @return
     */
    User getByName(String username);

    /**
     * 根据username获取role_name
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 根据username获取Permission_name
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

}
