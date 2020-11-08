package bigdemo.bd.service;

import bigdemo.bd.model.StuAdmin;

import java.util.List;

public interface StuAdminService {

    public List<StuAdmin> select1();
    public Integer delete(Integer id);
    public StuAdmin select(String username);
}
