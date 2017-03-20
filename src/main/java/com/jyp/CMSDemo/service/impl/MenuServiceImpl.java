package com.jyp.CMSDemo.service.impl;

import com.jyp.CMSDemo.dao.MenuDao;
import com.jyp.CMSDemo.pojo.Menu;
import com.jyp.CMSDemo.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/17 13:44
 * Describe :
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Resource
    MenuDao menuDao;


    @Override
    public List<Menu> listAllMenu() {
        return menuDao.listAllMenu();
    }

    @Override
    public List<Menu> listByParent(String parent) {
        return menuDao.listByParent(parent);
    }


    @Override
    public boolean saveMenu(Menu menu) {
        return menuDao.saveMenu(menu);
    }

    @Override
    public Menu getBySign(String menuSign) {
        return menuDao.getBySign(menuSign);
    }

    @Override
    public Menu getByName(String menuName) {
        return menuDao.getByName(menuName);
    }


    @Override
    public String getParentByPath(String path) {
        return menuDao.getParentByPath(path);
    }

    @Override
    public Menu getByParent(String parent) {
        return menuDao.getParent(parent);
    }
}
