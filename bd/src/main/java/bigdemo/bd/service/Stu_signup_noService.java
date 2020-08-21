package bigdemo.bd.service;

import bigdemo.bd.model.Stu_signup_no;

import java.io.IOException;
import java.util.List;

public interface Stu_signup_noService {
    public Integer addStu(Stu_signup_no stu_signup_no) throws IOException;
    public List<Stu_signup_no> selectAct();
    public List<Stu_signup_no> selectkey(Integer id);
    public Integer selectkey_pay(Integer id);
    public Integer update(Stu_signup_no stu_signup_no);
    public Integer select_actualprice(Integer id);
    public Integer delete(Integer id);
}
