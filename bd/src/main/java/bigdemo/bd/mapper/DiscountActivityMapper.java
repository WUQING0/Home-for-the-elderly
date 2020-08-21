package bigdemo.bd.mapper;

import bigdemo.bd.model.DiscountActivity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface DiscountActivityMapper {
    public Integer add(DiscountActivity discountActivity);
    public Integer delete(Integer id);
    public Integer update(DiscountActivity discountActivity);
    public List<DiscountActivity> select();
    public List<DiscountActivity> selectKey(Integer id);
    public Integer updateact(DiscountActivity discountActivity);
    public Integer updateact_num(Integer id);
    public Date select_start_time(Integer id);
    public Date select_end_time(Integer id);
    public Integer select_class_id(Integer id);

    public Integer selectAct_panduan(Integer id);
}
