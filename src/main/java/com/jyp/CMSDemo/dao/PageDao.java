package com.jyp.CMSDemo.dao;

import com.jyp.CMSDemo.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/14 15:58
 * Describe :
 */
public interface PageDao {
    /**
     * 根据id获取Page
     * @param id
     * @return
     */
    Page getById(int id);

    /**
     * 根据versionId获取page
     * @param versionId
     * @return
     */
    Page getByVersionId(String versionId);

    /**
     * 根据versionName获取Page
     * @param versionName
     * @return
     */
    Page getByVersionName(String versionName);

    /**
     * 修改page实体
     * @param page
     * @return 修改成功返回true，否则返回false
     */
    boolean updatePage(Page page);

    /**
     * 将page插入cms.page表中
     * @param page
     * @return
     */
    boolean savePage(Page page);

    /**
     * 根据pageNumber和pageSize获取Page列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Page> getPageByPageUtil(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

    /**
     * 获取Page总数
     * @return
     */
    int countAllPage();
}
