package bigdemo.bd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassAdmin {

    private Integer classId;    //班级编号

    private String className;   //班级名称

    private Integer vacancieNum;    //班级空缺人数

    private String state;       //班级状态，开班中/招生中

    private String classLeader;     //班级负责人

    private Integer payPrice;   //需支付价格

}
