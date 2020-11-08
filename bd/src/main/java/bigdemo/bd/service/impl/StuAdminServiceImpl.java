package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.StuAdminMapper;
import bigdemo.bd.model.StuAdmin;
import bigdemo.bd.service.StuAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StuAdminServiceImpl implements StuAdminService {

    @Autowired
    StuAdminMapper stuAdminMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<StuAdmin> select1() {
        return stuAdminMapper.select1();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer delete(Integer id) {
        return stuAdminMapper.delete(id);
    }
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public StuAdmin select(String username) {
        return stuAdminMapper.select(username);
    }
}
