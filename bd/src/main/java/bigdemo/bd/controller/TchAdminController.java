package bigdemo.bd.controller;

import bigdemo.bd.model.TchAdmin;
import bigdemo.bd.service.impl.TchAdminServiceImpl;
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
@RequestMapping(value = "/Teacher")
public class TchAdminController {

    @Autowired
    TchAdminServiceImpl tchAdminService;

    @RequestMapping(value = "/selectTch")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<TchAdmin> users = tchAdminService.selectTch();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<TchAdmin> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


    }

    @RequestMapping(value = "/deleteTch")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        System.out.println(id);
        tchAdminService.deleteTch(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insertTch")
    @ResponseBody
    public String insert(TchAdmin tchAdmin) {


        tchAdminService.addTch(tchAdmin);
        return "";
    }

    @RequestMapping(value = "/updateTch")
    @ResponseBody
    public String update(TchAdmin tchAdmin) {
        tchAdminService.updateTch(tchAdmin);
        return "";
    }

}
