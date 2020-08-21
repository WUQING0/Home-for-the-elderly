package bigdemo.bd.controller;

import bigdemo.bd.mapper.StuAdminMapper;
import bigdemo.bd.model.ClassAdmin;
import bigdemo.bd.model.StuAdmin;
import bigdemo.bd.model.StuInfo;
import bigdemo.bd.model.Stu_signup_no;

import bigdemo.bd.service.impl.ClassAdminServiceImpl;
import bigdemo.bd.service.impl.DiscountActivityServiceImpl;
import bigdemo.bd.service.impl.StuInfoServiceImpl;
import bigdemo.bd.service.impl.Stu_signup_noServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "/Stu_signup_no")
public class Stu_signup_noController {

    @Autowired
    Stu_signup_noServiceImpl stu_signup_noService;

    @Autowired
    StuInfoServiceImpl stuInfoService;

    @Autowired
    DiscountActivityServiceImpl discountActivityService;

    @Autowired
    ClassAdminServiceImpl classAdminService;

    @Autowired
    RedissonClient redis;

    @Autowired
    StuAdminMapper stuAdminMapper;

    @RequestMapping(value = "/insertStu")
    @ResponseBody
    public String insert(Stu_signup_no stu_signup_no) throws IOException {

        stu_signup_noService.addStu(stu_signup_no);
        return "";
    }

    @RequestMapping(value = "/insertStu_time")
    @ResponseBody
    public String insert_time(Stu_signup_no stu_signup_no, Integer id) throws IOException, ParseException {

        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date nowTime = null;
        Date beginTime=null;
        Date endsTime = null;

        nowTime = df.parse(df.format(new Date()));

        beginTime = df.parse(df.format(discountActivityService.select_start_time(id)));


        endsTime = df.parse(df.format(discountActivityService.select_end_time(id)));


        boolean flag = discountActivityService.belongCalendar(nowTime,beginTime,endsTime);

        if(flag==true){
            stu_signup_no.setClassId(discountActivityService.select_class_id(id));
            stu_signup_noService.addStu(stu_signup_no);
            map.put("code",0);
        }
        map.put("code",1);

        return "";
    }

    @RequestMapping(value = "/order")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        List<Stu_signup_no> users = stu_signup_noService.selectAct();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<Stu_signup_no> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;

    }
    @RequestMapping(value = "/order_pay")
    @ResponseBody
    public Map<String, Object> select(Integer page,
                                      Integer limit, Integer id){
        PageHelper.startPage(1, 1);
        System.out.println(limit);
        List<Stu_signup_no> users = stu_signup_noService.selectkey(id);// 这是我们的sql

        // 使用pageInfo包装查询
        PageInfo<Stu_signup_no> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/order_pay_confirm")
    @ResponseBody
    public Map<String, Object> select_confirm(Stu_signup_no stu_signup_no, HttpServletResponse response, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        final String key = new StringBuffer().append(stu_signup_no.getOrderId()).append(stu_signup_no.getStuId()).toString();
        RLock lock = redis.getLock(key);
        try {
            Boolean cacheRes = lock.tryLock(30,10,TimeUnit.SECONDS);
            if(cacheRes){
                if(classAdminService.selectClass_panduan(stu_signup_no.getClassId())>0||discountActivityService.selectAct_panduan(stu_signup_no.getClassId())>0) {
                    if (stu_signup_noService.select_actualprice(stu_signup_no.getOrderId()) == stu_signup_noService.selectkey_pay(stu_signup_no.getOrderId())) {
                        stu_signup_noService.delete(stu_signup_no.getOrderId());
                        StuInfo stuInfo = new StuInfo();
                        stuInfo.setStuId(stu_signup_no.getStuId());
                        stuInfo.setStuPicture(stu_signup_no.getStuPicture());
                        stuInfo.setStuName(stu_signup_no.getStuName());
                        stuInfo.setStuSex(stu_signup_no.getStuSex());
                        stuInfo.setStuClass(stu_signup_no.getClassId());
                        stuInfo.setPriceState("已完成");
                        stuInfo.setStuPhone(stu_signup_no.getStuPhone());
                        stuInfo.setStuAge(stu_signup_no.getStuAge());
                        stuInfo.setOrderAmount(stu_signup_no.getOrderPrice());
                        stuInfo.setActualAmount(stu_signup_no.getActualPrice());
                        stuInfoService.addStu(stuInfo);
                        ClassAdmin c = new ClassAdmin();
                        c.setClassId(stuInfo.getStuClass());
                        classAdminService.updateClasss(c);
                        discountActivityService.updateact_num(stuInfo.getStuClass());
                        StuAdmin stuAdmin=new StuAdmin();
                        stuAdmin.setStuId(String.valueOf(session.getAttribute("sid")));
                        stuAdmin.setStusId(String.valueOf(stu_signup_no.getStuId()));
                        stuAdminMapper.update(stuAdmin);


                        map.put("code", 0);
                    } else {
                        map.put("code", 1);
                    }
                }else {
                    map.put("code", 1);
                }
            }

        }finally {
            lock.unlock();
        }



        return map;
//        return courseAdminService.selectCourse();
    }
    }
