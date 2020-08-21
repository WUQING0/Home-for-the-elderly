package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.TimeTableMapper;
import bigdemo.bd.model.TimeTable;
import bigdemo.bd.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    TimeTableMapper timeTableMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer add(TimeTable timeTable) {
        return timeTableMapper.add(timeTable);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer delete(Integer id) {
        return timeTableMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer update(TimeTable timeTable) {
        return timeTableMapper.update(timeTable);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TimeTable> selectKey(Integer id) {
        return timeTableMapper.selectKey(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TimeTable> select() {
        return timeTableMapper.select();
    }
}
