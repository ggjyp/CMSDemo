package com.jyp.CMSDemo.service.impl;

import com.jyp.CMSDemo.dao.UserDao;
import com.jyp.CMSDemo.pojo.User;
import com.jyp.CMSDemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Author   : jyp
 * Date     : 2017/3/7 10:41
 * Describe :
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.getByName(username);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }
}
