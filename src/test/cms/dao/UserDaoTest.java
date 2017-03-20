package cms.dao;

import cms.BaseTest;
import com.jyp.CMSDemo.dao.UserDao;
import com.jyp.CMSDemo.pojo.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Author   : jyp
 * Date     : 2017/3/3 10:34
 * Describe :
 */

public class UserDaoTest extends BaseTest {
    @Resource
    UserDao userDao;

    @Test
    public void testGetById(){
        User user = userDao.getById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testGetByName(){
        User user = userDao.getByName("jyp");
        System.out.println(user.toString());
    }

    @Test
    public void testGetRoleName(){
        System.out.println(userDao.getRoles("jyp"));
    }

    @Test
    public void testGetPermissionName(){
        System.out.println(userDao.getPermissions("jyp"));
    }
}
