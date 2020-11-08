package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.MingXiMapper;
import bigdemo.bd.model.MingXi;
import bigdemo.bd.service.MingXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MingXiServiceImpl implements MingXiService {

    @Autowired
    MingXiMapper mingXiMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer add(MingXi mingXi) {
        return mingXiMapper.add(mingXi);
    }
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer delete(Integer id) {
        return mingXiMapper.delete(id);
    }
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer update(MingXi mingXi) {
        return mingXiMapper.update(mingXi);
    }
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<MingXi> select() {
        return mingXiMapper.select();
    }
}
