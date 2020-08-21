package bigdemo.bd.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TchAdmin {

    private Integer tchId;

    private String tchName;

    private String tchSubject;  //教授学科

    private Integer leaderClass;    //负责班级

    private String tchPhone;
}
