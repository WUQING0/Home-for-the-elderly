package bigdemo.bd.service;

import bigdemo.bd.model.DiscountActivity;

import java.util.Date;
import java.util.List;

public interface DiscountActivityService {
    public Integer addAct(DiscountActivity discountActivitycourseAdmin);
    public Integer deleteAct(Integer id);
    public Integer updateAct(DiscountActivity discountActivitycourseAdmin);
    public List<DiscountActivity> selectAct();
    public List<DiscountActivity> selectKeyAct(Integer id);
    public Integer updateActa(DiscountActivity discountActivitycourseAdmin);
    public Integer updateact_num(Integer id);
    public Date select_start_time(Integer id);
    public Date select_end_time(Integer id);
    public Integer select_class_id(Integer id);
    public Integer selectAct_panduan(Integer id);

    public Integer selectAct_panduan_class(Integer id);
}
