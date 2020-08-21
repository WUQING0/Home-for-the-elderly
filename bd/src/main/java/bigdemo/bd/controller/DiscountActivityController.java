package bigdemo.bd.controller;


import bigdemo.bd.model.DiscountActivity;
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
@RequestMapping(value = "/Act")
public class DiscountActivityController {

    @Autowired
    DiscountActivityServiceImpl discountActivityService;

    @RequestMapping(value = "/selectAct")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<DiscountActivity> users = discountActivityService.selectAct();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<DiscountActivity> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/deleteAct")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        System.out.println(id);
        discountActivityService.deleteAct(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insertAct")
    @ResponseBody
    public String insert(DiscountActivity discountActivity) {



        discountActivityService.addAct(discountActivity);
        return "";
    }

    @RequestMapping(value = "/updateAct")
    @ResponseBody
    public String update(DiscountActivity discountActivity) {
        discountActivityService.updateAct(discountActivity);
        return "";
    }

    @RequestMapping(value = "/updateActa")
    @ResponseBody
    public String updatea(DiscountActivity discountActivity) {
        discountActivityService.updateActa(discountActivity);
        return "";
    }
}

