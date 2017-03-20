package com.jyp.CMSDemo.controller;

import com.jyp.CMSDemo.pojo.Menu;
import com.jyp.CMSDemo.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author   : jyp
 * Date     : 2017/3/8 10:54
 * Describe : 资源管理
 */
@Controller
@RequestMapping(value = "file")
public class FileController {
    @Resource
    MenuService menuService;

    /**
     * 跳转至资源素材页面
     * @return
     */
    @RequestMapping(value = "material")
    public String resource_material() {return "resource_material";}

    /**
     * 跳转至资源文件管理页面
     * @return
     */
    @RequestMapping(value = "index")
    public String fileIndex(String path,HttpServletRequest request) {
        String preParent;

        if(path == null){
            path = "/menu";
            preParent = "/menu";
        }
        else {
            preParent = menuService.getParentByPath(path);
        }
        String dir = menuService.getByParent(path).getDir();
        List<Menu> menus;
        menus = menuService.listByParent(path);
        request.setAttribute("menus",menus);
        //赋值给‘上一级’的参数
        request.setAttribute("preParent",path);
        request.setAttribute("dir",dir);
        return "resource_file";
    }

    @RequestMapping(value = "addDir")
    public String addDir(Menu menu){
        if(menuService.saveMenu(menu)){
            return "redirect:/resource_file";
        }
        return null;
    }

    /**
     * 方法一上传文件
     */
    @RequestMapping("/uploadSingle")
    public String saveFile(String type, HttpServletRequest request, MultipartFile filedata) {
        // TODO Auto-generated method stub
        // 根据配置文件获取服务器图片存放路径
        String picDir = "";
        String fileName = filedata.getOriginalFilename();
//        String fileName = "test";
        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;

        picDir = request.getSession().getServletContext().getRealPath("upload")
                +"/" + type + "/" + File.separator;
        System.out.println(picDir);

        String saveFilePath = picDir;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + File.separator
                    + newFileName);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/resource_material";
    }





}
