package com.jyp.CMSDemo.service;

import com.jyp.CMSDemo.pojo.Page;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/15 10:28
 * Describe : 页面Service
 */

public interface PageService {

    Page getPageByVersionId(String versionId);

    boolean updatePage(Page page);

    List<Page> getPageByPages(int pageNumber, int pageSize);

    int countPageList();

    boolean savePage(Page page);

}
