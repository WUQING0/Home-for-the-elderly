package bigdemo.bd.service;

import bigdemo.bd.model.TimeTable;

import java.util.List;

public interface TimeTableService {

    public Integer add(TimeTable timeTable);

    public Integer delete(Integer id);

    public Integer update(TimeTable timeTable);

    public List<TimeTable> selectKey(Integer id);

    public List<TimeTable> select();
}
