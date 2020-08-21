package bigdemo.bd.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("bigdemo.bd.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {
}
