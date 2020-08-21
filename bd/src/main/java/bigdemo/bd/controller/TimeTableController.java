package bigdemo.bd.controller;

import bigdemo.bd.model.TimeTable;
import bigdemo.bd.service.impl.TimeTableServiceImpl;
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
@RequestMapping(value = "/TimeTable")
public class TimeTableController {

    @Autowired
    TimeTableServiceImpl timeTableService;

    @RequestMapping(value = "/insertTime")
    @ResponseBody
    public String insert(TimeTable timeTable) {


        timeTableService.add(timeTable);
        return "";
    }

    @RequestMapping(value = "/deleteTime")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        timeTableService.delete(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/updateTime")
    @ResponseBody
    public String update(TimeTable timeTable) {
        timeTableService.update(timeTable);
        return "";
    }

    @RequestMapping(value = "/selectTime")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit,Integer id) {
        PageHelper.startPage(page, limit);
        List<TimeTable> users = timeTableService.selectKey(id);// 这是我们的sql
        System.out.println(id+"===============");
        // 使用pageInfo包装查询
        PageInfo<TimeTable> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;

    }

    @RequestMapping(value = "/select_all")
    @ResponseBody
    public Map<String, Object> select_all(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<TimeTable> users = timeTableService.select();// 这是我们的sql

        // 使用pageInfo包装查询
        PageInfo<TimeTable> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;

    }
}
