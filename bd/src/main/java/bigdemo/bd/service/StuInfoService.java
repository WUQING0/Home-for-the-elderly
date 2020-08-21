package bigdemo.bd.service;

import bigdemo.bd.model.StuInfo;

import java.util.List;

public interface StuInfoService {
    public Integer addStu(StuInfo stuInfo);
    public Integer deleteStu(Integer id);
    public Integer updateStu(StuInfo stuInfo);
    public List<StuInfo> selectStu();
    public List<StuInfo> selectKeyStu(Integer id);

}
