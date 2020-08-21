package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.ClassAdminMapper;
import bigdemo.bd.model.ClassAdmin;
import bigdemo.bd.service.ClassAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
    班级管理模块
 */
@Service
public class ClassAdminServiceImpl implements ClassAdminService {

    @Autowired
    ClassAdminMapper classAdminMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addClass(ClassAdmin classAdmin) {


        return classAdminMapper.add(classAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer deleteClass(Integer id) {
        return classAdminMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateClass(ClassAdmin classAdmin) {
        return classAdminMapper.update(classAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<ClassAdmin> selectClass() {
        return classAdminMapper.select();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<ClassAdmin> selectKeyClass(Integer id) {
        return classAdminMapper.selectKey(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<ClassAdmin> selectClasss() {
        return classAdminMapper.selectClass();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateClasss(ClassAdmin classAdmin) {
        return classAdminMapper.updates(classAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateClassss(ClassAdmin classAdmin) {
        return classAdminMapper.updatess(classAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<ClassAdmin> selectkey_prices(Integer id) {
        return classAdminMapper.selectkey_price(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer selectClass_panduan(Integer id) {
        return classAdminMapper.selectClass_panduan(id);
    }
}
