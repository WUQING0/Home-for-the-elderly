package bigdemo.bd.service;

import bigdemo.bd.model.MoneyAdmin;

import java.util.List;

public interface MoneyAdminService {
    public Integer add(MoneyAdmin moneyAdmin);
    public Integer  delete(Integer id);
    public List<MoneyAdmin> select();
}
