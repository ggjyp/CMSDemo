package com.jyp.CMSDemo.util;

/**
 * Author   : jyp
 * Date     : 2017/3/15 10:06
 * Describe : 配合BootstrapTable插件，封装参数信息
 */
public class PageUtil {
    private int pageNumber;
    private int pageSize;

    public PageUtil(){

    }

    public int getPageNumber() {
        return pageNumber;
    }


    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }


    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
