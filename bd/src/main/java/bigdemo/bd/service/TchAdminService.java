package bigdemo.bd.service;


import bigdemo.bd.model.TchAdmin;

import java.util.List;

public interface TchAdminService {
    public Integer addTch(TchAdmin tchAdmin);
    public Integer deleteTch(Integer id);
    public Integer updateTch(TchAdmin tchAdmin);
    public List<TchAdmin> selectTch();
    public List<TchAdmin> selectKeyTch(Integer id);
}
