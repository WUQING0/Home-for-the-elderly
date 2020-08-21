package bigdemo.bd.config;


import bigdemo.bd.service.CustomRelam;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
/*
shiro通用化配置
 */
@Configuration
public class ShiroConfig {


    @Bean
    public CustomRelam customRelam(){
        return new CustomRelam();
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();

        securityManager.setRealm(customRelam());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/unauth");

        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/toLogin","anon");

        filterChainDefinitionMap.put("/student/order-list5_stu.html","authc");  //拦截认证的页面
        filterChainDefinitionMap.put("/student/order-list4_stu.html","authc");
        filterChainDefinitionMap.put("/student/order-list4_stu.html","perms[stu:select]");


        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);     //过滤器链
        bean.setLoginUrl("/toLogin");               //设置登陆页面
        bean.setUnauthorizedUrl("/noauth");         //设置未经授权的页面
        return bean;
    }
}
