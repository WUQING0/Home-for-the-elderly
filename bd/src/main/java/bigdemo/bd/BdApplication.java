package bigdemo.bd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bigdemo.bd.mapper")
public class BdApplication {
    public static void main(String[] args) {
        SpringApplication.run(BdApplication.class, args);
    }

}
