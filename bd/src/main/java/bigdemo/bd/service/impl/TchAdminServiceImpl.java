package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.TchAdminMappr;
import bigdemo.bd.model.TchAdmin;
import bigdemo.bd.service.TchAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
    教师信息管理模块
 */
@Service
public class TchAdminServiceImpl implements TchAdminService {

    @Autowired
    TchAdminMappr tchAdminMappr;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addTch(TchAdmin tchAdmin) {
        return tchAdminMappr.add(tchAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer deleteTch(Integer id) {
        return tchAdminMappr.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateTch(TchAdmin tchAdmin) {
        return tchAdminMappr.update(tchAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TchAdmin> selectTch() {
        return tchAdminMappr.select();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TchAdmin> selectKeyTch(Integer id) {
        return tchAdminMappr.selectKey(id);
    }
}
