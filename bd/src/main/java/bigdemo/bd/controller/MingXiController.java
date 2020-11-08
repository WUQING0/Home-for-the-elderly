package bigdemo.bd.controller;

import bigdemo.bd.model.MingXi;
import bigdemo.bd.service.impl.MingXiServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Ming")
public class MingXiController {

    @Autowired
    MingXiServiceImpl mingXiService;

    @RequestMapping(value = "/select")
    @ResponseBody
    public Map<String, Object> select(Integer page,
                                      Integer limit) {
        PageHelper.startPage(page, limit);
        System.out.println(page+"zzzzzzzzzzzzz");
        List<MingXi> users = mingXiService.select();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<MingXi> rolePageInfo = new PageInfo<>(users);//
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
        mingXiService.delete(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert(MingXi mingXi) {

        mingXiService.add(mingXi);

        return "";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(MingXi mingXi) {
        mingXiService.update(mingXi);
        return "";
    }
}
