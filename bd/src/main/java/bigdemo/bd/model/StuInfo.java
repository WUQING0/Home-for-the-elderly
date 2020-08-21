package bigdemo.bd.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StuInfo {
    private Integer stuId;

    private String stuPicture;  //学生照片

    private String stuName;

    private String stuSex;

    private Integer stuClass;

    private String priceState;  //缴费情况

    private String stuPhone;

    private Integer stuAge;

    private Integer orderAmount;    //订单的订单金额

    private Integer actualAmount;   //实际缴费金额

}
