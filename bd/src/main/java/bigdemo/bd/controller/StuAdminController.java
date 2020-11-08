package bigdemo.bd.controller;

import bigdemo.bd.model.StuAdmin;
import bigdemo.bd.service.impl.StuAdminServiceImpl;
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
@RequestMapping(value = "/StuRoleAdmin")
public class StuAdminController {

    @Autowired
    StuAdminServiceImpl stuAdminService;

    @RequestMapping(value = "/select")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<StuAdmin> users = stuAdminService.select1();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<StuAdmin> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        System.out.println(id);
        stuAdminService.delete(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

}
