package bigdemo.bd.mapper;

import bigdemo.bd.model.MingXi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MingXiMapper {
    public Integer add(MingXi mingXi);
    public Integer delete(Integer id);
    public Integer update(MingXi mingXi);
    public List<MingXi> select();
}
