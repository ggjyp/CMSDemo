package com.jyp.CMSDemo.service;

import com.jyp.CMSDemo.pojo.Menu;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/17 13:44
 * Describe :
 */
public interface MenuService {
    List<Menu> listAllMenu();
    List<Menu> listByParent(String parent);
    boolean saveMenu(Menu menu);
    Menu getBySign(String menuSign);
    Menu getByName(String menuName);
    String getParentByPath(String path);
    Menu getByParent(String parent);

}