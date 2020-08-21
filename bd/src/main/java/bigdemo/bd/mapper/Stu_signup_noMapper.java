package bigdemo.bd.mapper;

import bigdemo.bd.model.Stu_signup_no;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Stu_signup_noMapper {
    public Integer add(Stu_signup_no stu_signup_no);
    public List<Stu_signup_no> select();
    public List<Stu_signup_no> selectkey(Integer id);
    public Integer selectkey_pay(Integer id);
    public Integer update(Stu_signup_no stu_signup_no);
    public Integer select_actualprice(Integer id);
    public Integer delete(Integer id);
}
