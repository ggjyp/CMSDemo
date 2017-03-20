package cms.dao;

import cms.BaseTest;
import com.jyp.CMSDemo.dao.PageDao;
import com.jyp.CMSDemo.pojo.Page;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/14 16:16
 * Describe :
 */
public class PageDaoTest extends BaseTest{
    @Resource
    PageDao pageDao;

    @Test
    public void testGetByVersionId(){
        Page page = pageDao.getByVersionId("0.1");
        System.out.println(page.toString());
    }

    @Test
    public void testGetByVersionName(){
        Page page = pageDao.getByVersionName("测试0.2");
        System.out.println(page.toString());
    }

    @Test
    public void testSavePage(){
        Page page = new Page("1.1", "正式1.1");
        if(pageDao.savePage(page)){
            System.out.println(page.toString());
        }
        else{
            System.out.println("save error");
        }

    }

    @Test
    public void testUpdatePage(){
        Page page = new Page(0, "1.1", "正式1.1111", "headCode1.1111", "bodyCode1.1111");
        if(pageDao.updatePage(page)){
            System.out.println(page.toString());
        }
        else {
            System.out.println("update error");
        }
    }

    @Test
    public void testGetPageByPageUtil(){
        int pageNumber = 1;
        int pageSize = 10;
        List<Page> pages = pageDao.getPageByPageUtil(pageNumber, pageSize);
        for (Page page : pages){
            System.out.println(page.toString());
        }
    }

    @Test
    public void testGetCountPage() {
        System.out.println(pageDao.countAllPage());
    }

}
