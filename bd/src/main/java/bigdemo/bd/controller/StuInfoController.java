package bigdemo.bd.controller;

import bigdemo.bd.mapper.StuAdminMapper;
import bigdemo.bd.model.ClassAdmin;
import bigdemo.bd.model.StuInfo;
import bigdemo.bd.service.impl.ClassAdminServiceImpl;
import bigdemo.bd.service.impl.FaceDetect;
import bigdemo.bd.service.impl.StuInfoServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/Student")
public class StuInfoController {

    @Autowired
    StuInfoServiceImpl stuInfoService;

    @Autowired
    ClassAdminServiceImpl classAdminService;

    @Autowired
    StuAdminMapper stuAdminMapper;

    @RequestMapping(value = "/selectStu")
    @ResponseBody
    public Map<String, Object> select(int page,
                                      int limit) {
        PageHelper.startPage(page, limit);
        System.out.println(limit);
        List<StuInfo> users = stuInfoService.selectStu();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<StuInfo> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

    @RequestMapping(value = "/selectStus")
    @ResponseBody
    public List<StuInfo> selectstus() {

        List<StuInfo> users = stuInfoService.selectStu();// 这是我们的sql
        return users;


//        return courseAdminService.selectCourse();
    }
    @RequestMapping(value = "/deleteStu")
    @ResponseBody
    public Map<String, Object> delete(Integer id, Integer stuClass) {
        System.out.println(id);
        stuInfoService.deleteStu(id);

        ClassAdmin c = new ClassAdmin();
        c.setClassId(stuClass);
        classAdminService.updateClassss(c);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data.state", 1);
        return map;
    }

    @RequestMapping(value = "/insertStu")
    @ResponseBody
    public String insert(StuInfo stuInfo) throws IOException {

        if(classAdminService.selectClass_panduan(stuInfo.getStuClass())>0) {
            String save_path = "/pic/" + stuInfo.getStuId() + ".jpg";   //存到数据库的路径
            String o_path = "D:/下载包/bd/src/main/webapp/pic/" + stuInfo.getStuId() + ".jpg";   //流写到目标路径中
            FaceDetect faceDetect = new FaceDetect();
            boolean hasFace = faceDetect.detect(stuInfo.getStuPicture(), "d:\\pic\\" + stuInfo.getStuId() + ".jpg");
            if (hasFace) {
                System.out.println("照片检测到人脸！");
                File i = new File(stuInfo.getStuPicture());//读取要拷贝的文件
                File o = new File(o_path);//准备写入拷贝完的图片
                FileInputStream fs = new FileInputStream(i);
                FileOutputStream f = new FileOutputStream(o);
                int len = -1;
                byte[] flush = new byte[1024];
                while ((len = fs.read(flush)) != -1) {
                    f.write(flush);
                    f.flush();
                }
                fs.close();
                f.close();
                stuInfo.setStuPicture(save_path);  //一定存储的为save_path 自定义的保存路径
                stuInfoService.addStu(stuInfo);
                ClassAdmin c = new ClassAdmin();
                c.setClassId(stuInfo.getStuClass());
                classAdminService.updateClasss(c);
            } else {
                System.out.println("照片无法识别人脸111111111111");
            }
        }
        return "";
    }

    @RequestMapping(value = "/updateStu")
    @ResponseBody
    public String update(StuInfo stuInfo) throws IOException {

        String save_path = "/pic/" + stuInfo.getStuId() + ".jpg";   //存到数据库的路径
        String o_path = "D:/下载包/bd/src/main/webapp/pic/" + stuInfo.getStuId() + ".jpg";   //流写到目标路径中
        FaceDetect faceDetect = new FaceDetect();
        boolean hasFace = faceDetect.detect(stuInfo.getStuPicture(), "d:\\pic\\" + stuInfo.getStuId() + ".jpg");
        if (hasFace) {
            System.out.println("照片检测到人脸！");
            File i = new File(stuInfo.getStuPicture());//读取要拷贝的文件
            File o = new File(o_path);//准备写入拷贝完的图片
            FileInputStream fs = new FileInputStream(i);
            FileOutputStream f = new FileOutputStream(o);
            int len = -1;
            byte[] flush = new byte[1024];
            while ((len = fs.read(flush)) != -1) {
                f.write(flush);
                f.flush();
            }
            fs.close();
            f.close();
            stuInfo.setStuPicture(save_path);  //一定存储的为save_path 自定义的保存路径
            stuInfoService.updateStu(stuInfo);
        } else {
            System.out.println("照片无法识别人脸2222222");
        }
        return "";
    }

    @RequestMapping(value = "/selectStuKey")
    @ResponseBody
    public Map<String, Object> selectkey(int page,
                                         int limit, String id, HttpSession session) {
        PageHelper.startPage(page, limit);
        id= String.valueOf(session.getAttribute("sid"));
        System.out.println(session.getAttribute("sid")+"哇哇哇哇哇哇哇哇哇哇哇哇哇哇");
        Integer ids=stuAdminMapper.selectkey(id);
        List<StuInfo> users = stuInfoService.selectKeyStu(ids);// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<StuInfo> rolePageInfo = new PageInfo<>(users);//
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;


//        return courseAdminService.selectCourse();
    }

}
