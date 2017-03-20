package com.jyp.CMSDemo.dao;

import com.jyp.CMSDemo.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/17 13:37
 * Describe : Menu实体类的Dao接口
 */
public interface MenuDao {

    /**
     * 根据根据parent获取menu列表
     * @param parent
     * @return
     */
    List<Menu> listByParent(String parent);



    /**
     * 获取所以目录信息
     * @return
     */
    List<Menu> listAllMenu();

    /**
     * 新增目录信息
     * @return
     */
    boolean saveMenu(Menu menu);

    /**
     * 根据MenuSign获取Menu信息
     * @param menuSign 目录标志
     * @return
     */
    Menu getBySign(String menuSign);

    /**
     * 根据MenuName获取Menu信息
     * @param menuName
     * @return
     */
    Menu getByName(String menuName);

    /**
     * 根据path获取该文件的Parent
     * @param path
     * @return
     */
    String getParentByPath(String path);

    /**
     * 根据parent参数获取Parent Menu对象
     * @param parent
     * @return
     */
    Menu getParent(String parent);



}
