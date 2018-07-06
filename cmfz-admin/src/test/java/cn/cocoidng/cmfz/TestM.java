package cn.cocoidng.cmfz;

import cn.cocoding.cmfz.dao.AccordionDao;
import cn.cocoding.cmfz.dao.ManagerDao;
import cn.cocoding.cmfz.entity.Manager;
import cn.cocoding.cmfz.service.CarouselService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huzi on 2018/7/4.
 */
public class TestM {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test(){
        /*ManagerDao managerDao = (ManagerDao) context.getBean("managerDao");
        Manager zs = managerDao.selectByManagerName("zs");
        System.out.println(zs);*/
        AccordionDao accordionDao = (AccordionDao) context.getBean("accordionDao");
        System.out.println(accordionDao.selectAccordionsByLevel(1));

    }
    @Test
    public void test1(){
        AccordionDao accordionDao = (AccordionDao) context.getBean("accordionDao");
        System.out.println(accordionDao.selectAccordionByText("持明法洲之用户").getId());
    }
    @Test
    public void test2(){
        AccordionDao accordionDao = (AccordionDao) context.getBean("accordionDao");
        System.out.println(accordionDao.selectAccordionsByPid(accordionDao.selectAccordionByText("持明法洲之用户").getId()));
    }

}
