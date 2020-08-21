package bigdemo.bd.controller;


import bigdemo.bd.model.ClassAdmin;
import bigdemo.bd.service.ClassAdminService;
import bigdemo.bd.service.impl.ClassAdminServiceImpl;
import bigdemo.bd.service.impl.DiscountActivityServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Class")
public class ClassAdminController {

    @Autowired
    ClassAdminServiceImpl classAdminService;

    @Autowired
    DiscountActivityServiceImpl discountActivityService;

    @RequestMapping(value = "/selectClass")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<ClassAdmin> users = classAdminService.selectClass();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<ClassAdmin> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/deleteClass")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        System.out.println(id);
        classAdminService.deleteClass(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insertClass")
    @ResponseBody
    public String insert(ClassAdmin classAdmin) {

            classAdminService.addClass(classAdmin);

        return "";
    }

    @RequestMapping(value = "/updateClass")
    @ResponseBody
    public String update(ClassAdmin classAdmin) {
        classAdminService.updateClass(classAdmin);
        return "";
    }

    //异步为了后续直接添加下拉框显示班级准备
    @RequestMapping(value = "/selectClasss")
    @ResponseBody
    public List<ClassAdmin> selectClass() {
        return classAdminService.selectClasss();


//        return courseAdminService.selectCourse();
    }

    //异步为了后续直接添加下拉框显示班级准备
    @RequestMapping(value = "/selectClasss_time")
    @ResponseBody
    public Integer selectClass_time(Integer id) {
        return discountActivityService.select_class_id(id);


//        return courseAdminService.selectCourse();
    }

    //异步为了后续直接添加下拉框显示班级准备
    @RequestMapping(value = "/selectClasss_price")
    @ResponseBody
    public List<ClassAdmin> selectClass(Integer id) {
        return classAdminService.selectkey_prices(id);

//        return courseAdminService.selectCourse();
    }
}
