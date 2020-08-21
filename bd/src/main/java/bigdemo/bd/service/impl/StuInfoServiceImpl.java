package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.StuInfoMapper;
import bigdemo.bd.model.StuInfo;
import bigdemo.bd.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
    学员信息管理模块
 */
@Service
public class StuInfoServiceImpl implements StuInfoService {

    @Autowired
    StuInfoMapper stuInfoMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addStu(StuInfo stuInfo) {

        return stuInfoMapper.add(stuInfo);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer deleteStu(Integer id) {
        return stuInfoMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateStu(StuInfo stuInfo) {
        return stuInfoMapper.update(stuInfo);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<StuInfo> selectStu() {
        return stuInfoMapper.select();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<StuInfo> selectKeyStu(Integer id) {
        return stuInfoMapper.selectKey(id);
    }
}
