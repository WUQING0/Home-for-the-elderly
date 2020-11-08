package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.MoneyAdminMapper;
import bigdemo.bd.model.MoneyAdmin;
import bigdemo.bd.service.MoneyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MoneyAdminServiceImpl implements MoneyAdminService {

    @Autowired
    MoneyAdminMapper moneyAdminMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer add(MoneyAdmin moneyAdmin) {
        return moneyAdminMapper.add(moneyAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer delete(Integer id) {
        return moneyAdminMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<MoneyAdmin> select() {
        return moneyAdminMapper.select();
    }
}
