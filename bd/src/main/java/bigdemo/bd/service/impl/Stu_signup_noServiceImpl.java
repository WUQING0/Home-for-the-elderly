package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.Stu_signup_noMapper;
import bigdemo.bd.model.Stu_signup_no;
import bigdemo.bd.service.Stu_signup_noService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;
import java.util.Random;

@Service
public class Stu_signup_noServiceImpl implements Stu_signup_noService {

    @Autowired
    Stu_signup_noMapper stu_signup_noMapper;

    private SnowFlake snowFlake = new SnowFlake(2, 3);

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addStu(Stu_signup_no stu_signup_no) throws IOException {
        Random rand = new Random();
        final String key = new StringBuffer().append(stu_signup_no.getClassId()).append(rand.nextInt(1000)).toString();

        stu_signup_no.setOrderId(Math.abs((int) snowFlake.nextId()));     //订单编号

        stu_signup_no.setStuId(Integer.valueOf(key));  //学号

        stu_signup_no.setActualPrice(0);

        String save_path = "/pic/" + stu_signup_no.getStuId() + ".jpg";   //存到数据库的路径
        String o_path = "D:/下载包/bd/src/main/webapp/pic/" + stu_signup_no.getStuId() + ".jpg";   //流写到目标路径中

        FaceDetect faceDetect = new FaceDetect();
        boolean hasFace = faceDetect.detect(stu_signup_no.getStuPicture(), "d:\\pic\\" + stu_signup_no.getStuId() + ".jpg");
        if (hasFace) {
            System.out.println("照片检测到人脸！");
            File i = new File(stu_signup_no.getStuPicture());//读取要拷贝的文件
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
            stu_signup_no.setStuPicture(save_path);  //一定存储的为save_path 自定义的保存路径
        } else {
            System.out.println("照片无法识别人脸");
        }
        return stu_signup_noMapper.add(stu_signup_no);
    }


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<Stu_signup_no> selectAct() {
        return stu_signup_noMapper.select();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<Stu_signup_no> selectkey(Integer id) {
        return stu_signup_noMapper.selectkey(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer selectkey_pay(Integer id) {
        return stu_signup_noMapper.selectkey_pay(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer update(Stu_signup_no stu_signup_no) {
        return stu_signup_noMapper.update(stu_signup_no);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer select_actualprice(Integer id) {
        return stu_signup_noMapper.select_actualprice(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer delete(Integer id) {
        return stu_signup_noMapper.delete(id);
    }
}
