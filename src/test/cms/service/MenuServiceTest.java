package cms.service;

import cms.BaseTest;
import com.jyp.CMSDemo.pojo.Menu;
import com.jyp.CMSDemo.pojo.User;
import com.jyp.CMSDemo.service.MenuService;
import com.jyp.CMSDemo.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Author   : jyp
 * Date     : 2017/3/3 10:34
 * Describe :
 */
public class MenuServiceTest extends BaseTest{
    @Resource
    MenuService menuService;

    @Test
    public void testListAllMenu() {
        for(Menu menu : menuService.listAllMenu()){
            System.out.println(menu.toString());
        }
    }

    @Test
    public void testGetByName() {
        System.out.println(menuService.getByName("根目录"));
    }

    @Test
    public void testListByParent() {
        for(Menu menu : menuService.listByParent("/test")){
            System.out.println(menu.toString());
        }
    }

    @Test
    public void testGetParentByPath() {
        System.out.println(menuService.getParentByPath("/test"));
    }

}
