package bigdemo.bd.mapper;

import bigdemo.bd.model.CourseAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface CourseAdminMapper {
    public Integer add(CourseAdmin courseAdmin);
    public Integer delete(Integer id);
    public Integer update(CourseAdmin courseAdmin);
    public List<CourseAdmin> select();
    public List<CourseAdmin> selectKey();
}
