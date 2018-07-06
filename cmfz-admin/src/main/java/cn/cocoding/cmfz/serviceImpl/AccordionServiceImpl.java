package cn.cocoding.cmfz.serviceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import cn.cocoding.cmfz.entity.Accordion;
import cn.cocoding.cmfz.dao.AccordionDao;
import cn.cocoding.cmfz.service.AccordionService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccordionServiceImpl implements AccordionService {

    @Resource
    private AccordionDao accordionDao;

    @Override
    public int insert(Accordion accordion) {
        return accordionDao.insert(accordion);
    }

    @Override
    public int insertSelective(Accordion accordion) {
        return accordionDao.insertSelective(accordion);
    }

    @Override
    public int insertList(List<Accordion> accordions) {
        return accordionDao.insertList(accordions);
    }

    /**/
    @Override
    public int update(Accordion accordion) {
        return accordionDao.update(accordion);
    }

    /**/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Accordion> queryAccordionsByLevel(Integer level) {
        return accordionDao.selectAccordionsByLevel(level);
    }

    /**/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Accordion> queryAccordionsByText(String text) {
        return accordionDao.selectAccordionsByPid(accordionDao.selectAccordionByText(text).getId());
    }
}
