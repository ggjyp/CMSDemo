package com.jyp.CMSDemo.controller;

import com.jyp.CMSDemo.pojo.Page;
import com.jyp.CMSDemo.service.PageService;
import com.jyp.CMSDemo.util.PageUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author   : jyp
 * Date     : 2017/3/14 15:43
 * Describe : 页面管理
 */
@Controller
@RequestMapping(value = "page")
public class PageController {
    @Resource
    PageService pageService;

    /**
     * 分页，根据pageSize和pageNumber获取对应Page列表，封装成json字符串后作为bootstrap-table的数据源
     * jsp页面的data-filed字段内容必须与json字符串中的key一致
     * @param pageSize 页面大小
     * @param pageNumber 页码
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map pageList(int pageSize, int pageNumber) throws
            IOException {

        //根据当前页码和页面大小获取页面记录表
        List<Page> pageList = pageService.getPageByPages((pageNumber-1)*pageSize, pageSize);
        //获取总记录数
        int total = pageService.countPageList();
        //将数据转换成json
        //bootstrap-table必须要total、rows参数
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", pageList);
       return map;
    }

    //跳转至编辑页面页面
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
    public String editPage(HttpServletRequest request, Model model){
        Page page = pageService.getPageByVersionId(request.getParameter("versionId"));
        model.addAttribute("page",page);
        return "page_edit";
    }

    /**
     * 编辑页面，编辑成功则重定向至page_manager页面
     * @param versionId
     * @param versionName
     * @param headCode
     * @param bodyCode
     * @return
     */
    @RequestMapping(value = "/edit_result", method = RequestMethod.POST)
    public String editPageResult(String versionId, String versionName, String headCode, String bodyCode){
        Page page = new Page (0, versionId, versionName, headCode, bodyCode);
        System.out.println(page.toString());
        if (pageService.updatePage(page)){
            return "page_manager";
        }
        return null;
    }

    /**
     * 跳转至新增页面页面
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String addPage() { return "page_add";}

    /**
     * 新增页面，将表单提交的数据封装成Page页面实体
     * @param page
     * @return
     */
    @RequestMapping(value = "/add_result")
    public String addPageResult(Page page) {
        System.out.println(page.toString());
        if (pageService.savePage(page)){
            return "page_manager";
        }
        return null;
    }

}
