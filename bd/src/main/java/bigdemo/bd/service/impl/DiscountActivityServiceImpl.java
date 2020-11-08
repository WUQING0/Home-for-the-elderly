package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.DiscountActivityMapper;
import bigdemo.bd.model.DiscountActivity;
import bigdemo.bd.service.DiscountActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
/*
    优惠活动管理模块
 */
@Service
public class DiscountActivityServiceImpl implements DiscountActivityService {

    @Autowired
    DiscountActivityMapper discountActivityMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addAct(DiscountActivity discountActivity) {
        return discountActivityMapper.add(discountActivity);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer deleteAct(Integer id) {
        return discountActivityMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateAct(DiscountActivity discountActivity) {
        return discountActivityMapper.update(discountActivity);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<DiscountActivity> selectAct() {
        return discountActivityMapper.select();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<DiscountActivity> selectKeyAct(Integer id) {
        return discountActivityMapper.selectKey(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateActa(DiscountActivity discountActivity) {
        return discountActivityMapper.updateact(discountActivity);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateact_num(Integer id) {
        return discountActivityMapper.updateact_num(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Date select_start_time(Integer id) {

        return discountActivityMapper.select_start_time(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Date select_end_time(Integer id) {
        return discountActivityMapper.select_end_time(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer select_class_id(Integer id) {
        return discountActivityMapper.select_class_id(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer selectAct_panduan(Integer id) {
        return discountActivityMapper.selectAct_panduan(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer selectAct_panduan_class(Integer id) {
        return discountActivityMapper.selectAct_panduan_class(id);
    }

    public  boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        //设置结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        //处于开始时间之后，和结束时间之前的判断
        if (date.after(begin) && date.before(end)||date.after(end)&& date.before(begin)) {
            return true;
        } else {
            return false;
        }

    }
}
