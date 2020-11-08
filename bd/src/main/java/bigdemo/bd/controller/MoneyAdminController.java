package bigdemo.bd.controller;

import bigdemo.bd.model.MoneyAdmin;
import bigdemo.bd.service.impl.MoneyAdminServiceImpl;
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
@RequestMapping(value = "/Price")
public class MoneyAdminController {

    @Autowired
    MoneyAdminServiceImpl moneyAdminService;

    @RequestMapping(value = "/selectPrice")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<MoneyAdmin> users = moneyAdminService.select();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<MoneyAdmin> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/deletePrice")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        moneyAdminService.delete(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }
    @RequestMapping(value = "/insertPrice")
    @ResponseBody
    public String insert(MoneyAdmin moneyAdmin) {
        moneyAdminService.add(moneyAdmin);
        return "";
    }
}
