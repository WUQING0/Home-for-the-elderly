package bigdemo.bd.mapper;

import bigdemo.bd.model.StuAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StuAdminMapper {
    StuAdmin select(String stuId);
    Integer selectkey(String stuid);
    Integer update(StuAdmin stuAdmin);
}
