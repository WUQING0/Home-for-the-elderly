package bigdemo.bd.mapper;

import bigdemo.bd.model.TchAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TchAdminMappr {
    public Integer add(TchAdmin tchAdmin);
    public Integer delete(Integer id);
    public Integer update(TchAdmin tchAdmin);
    public List<TchAdmin> select();
    public List<TchAdmin> selectKey(Integer id);
}
