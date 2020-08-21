package bigdemo.bd.mapper;

import bigdemo.bd.model.TimeTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeTableMapper {

    public Integer add(TimeTable timeTable);

    public Integer delete(Integer id);

    public Integer update(TimeTable timeTable);

    public List<TimeTable> selectKey(Integer id);

    public List<TimeTable> select();
}
