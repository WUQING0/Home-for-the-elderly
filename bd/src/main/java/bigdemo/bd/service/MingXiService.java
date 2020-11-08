package bigdemo.bd.service;

import bigdemo.bd.model.MingXi;

import java.util.List;

public interface MingXiService {
    public Integer add(MingXi mingXi);
    public Integer delete(Integer id);
    public Integer update(MingXi mingXi);
    public List<MingXi> select();
}
