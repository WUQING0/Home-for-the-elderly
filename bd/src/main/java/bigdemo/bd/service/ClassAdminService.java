package bigdemo.bd.service;

import bigdemo.bd.model.ClassAdmin;

import java.util.List;

public interface ClassAdminService {

    public Integer addClass(ClassAdmin classAdmin);
    public Integer deleteClass(Integer id);
    public Integer updateClass(ClassAdmin classAdmin);
    public List<ClassAdmin> selectClass();
    public List<ClassAdmin> selectKeyClass(Integer id);
    public List<ClassAdmin> selectClasss();
    public Integer updateClasss(ClassAdmin classAdmin);

    public Integer updateClassss(ClassAdmin classAdmin);

    public List<ClassAdmin> selectkey_prices(Integer id);
    public Integer selectClass_panduan(Integer id);
}
