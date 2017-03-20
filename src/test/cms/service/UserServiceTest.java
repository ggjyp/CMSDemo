package cms.service;

import cms.BaseTest;
import com.jyp.CMSDemo.pojo.User;
import com.jyp.CMSDemo.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Author   : jyp
 * Date     : 2017/3/3 10:34
 * Describe :
 */
public class UserServiceTest extends BaseTest{
    @Resource
    UserService userService;

    @Test
    public void testLogin(){
        User user = userService.login("jyp","123456");
        System.out.println(user.toString());
    }

    @Test
    public void testGetRoles() {
        System.out.println(userService.getRoles("jyp"));
    }

    @Test
    public void testGetPermission() {
        System.out.println(userService.getPermissions("jyp"));
    }
}
