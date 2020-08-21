package bigdemo.bd.controller;

import bigdemo.bd.model.CourseAdmin;
import bigdemo.bd.service.impl.CourseAdminServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Course")
public class CourseAdminController {

    @Autowired
    CourseAdminServiceImpl courseAdminService;

    @RequestMapping(value = "/selectCourse")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<CourseAdmin> users = courseAdminService.selectCourse();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<CourseAdmin> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/deleteCourse")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        System.out.println(id);
        courseAdminService.deleteCourse(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insertCourse")
    @ResponseBody
    public String insert(CourseAdmin courseAdmin) {
        System.out.println(courseAdmin.getCourseName());
        courseAdminService.addCourse(courseAdmin);
        return "";
    }

    @RequestMapping(value = "/updateCourse")
    @ResponseBody
    public String update(CourseAdmin courseAdmin) {
        System.out.println(courseAdmin.getCourseName());
        courseAdminService.updateCourse(courseAdmin);
        return "";
    }


    @RequestMapping(value = "/selectCourseKey")
    @ResponseBody
    public List<CourseAdmin> selectKey() {
        return courseAdminService.selectKeyCourse();

    }
}
