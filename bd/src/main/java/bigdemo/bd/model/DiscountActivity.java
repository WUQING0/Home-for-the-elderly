package bigdemo.bd.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
public class DiscountActivity {

    private Integer actId;      //活动编号

    private String actName;     //活动名称

    private Integer actNum;     //活动计划人数

    private  Integer surplusNum;    // 活动剩余人数

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;     //开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;       //结束时间

    private Integer price;      //优惠价格(便宜多少钱)

    private String state;       //状态    未开始/正在进行/已结束

    private Integer classId;  //所选择的班级号


}
