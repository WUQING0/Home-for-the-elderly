package bigdemo.bd.model;

import lombok.Getter;
import lombok.Setter;

/*
无优惠情况下的报名
 */
@Setter
@Getter
public class Stu_signup_no {
    private Integer orderId;  //订单编号

    private Integer stuId;  //学号

    private String stuPicture;  //学生照片

    private String stuName; //学生姓名

    private Integer classId;    //班号

    private String stuSex;  //性别

    private Integer stuAge; //年龄

    private String stuPhone;   //学生手机号

    private Integer orderPrice; //订单编号

    private Integer actualPrice;     //实际支付价格

    @Override
    public String toString() {
        return orderId+"=======";
    }
}
