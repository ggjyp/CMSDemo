package com.jyp.CMSDemo.service.impl;

import com.jyp.CMSDemo.dao.PageDao;
import com.jyp.CMSDemo.pojo.Page;
import com.jyp.CMSDemo.service.PageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/15 10:31
 * Describe : PageService实现类
 */
@Service
public class PageServiceImpl implements PageService {
    @Resource
    PageDao pageDao;


    @Override
    public Page getPageByVersionId(String versionId) {
        return pageDao.getByVersionId(versionId);
    }

    @Override
    public boolean updatePage(Page page) {
        return pageDao.updatePage(page);
    }

    @Override
    public List<Page> getPageByPages(int pageNumber, int pageSize) {
        return pageDao.getPageByPageUtil(pageNumber, pageSize);
    }

    @Override
    public int countPageList() {
        return pageDao.countAllPage();
    }

    @Override
    public boolean savePage(Page page) {
        return pageDao.savePage(page);
    }
}
