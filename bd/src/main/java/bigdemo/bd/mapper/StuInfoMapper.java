package bigdemo.bd.mapper;

import bigdemo.bd.model.StuInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StuInfoMapper {
    public Integer add(StuInfo stuInfo);
    public Integer delete(Integer id);
    public Integer update(StuInfo stuInfo);
    public List<StuInfo> select();
    public List<StuInfo> selectKey(Integer id);
}
