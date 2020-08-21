package bigdemo.bd.mapper;

import bigdemo.bd.model.ClassAdmin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface ClassAdminMapper {

    public Integer add(ClassAdmin classAdmin);
    public Integer delete(Integer id);
    public Integer update(ClassAdmin classAdmin);
    public List<ClassAdmin> select();
    public List<ClassAdmin> selectKey(Integer id);
    public List<ClassAdmin> selectClass();
    public Integer updates(ClassAdmin classAdmin);
    public Integer updatess(ClassAdmin classAdmin);
    public List<ClassAdmin> selectkey_price(Integer id);
    public Integer selectClass_panduan(Integer id);
}
