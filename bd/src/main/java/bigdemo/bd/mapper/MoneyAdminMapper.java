package bigdemo.bd.mapper;

import bigdemo.bd.model.MoneyAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MoneyAdminMapper {

    public Integer delete(Integer id);
    public List<MoneyAdmin> select();
    public Integer add(MoneyAdmin moneyAdmin);

}
