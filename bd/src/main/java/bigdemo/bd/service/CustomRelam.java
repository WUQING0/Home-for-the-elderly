package bigdemo.bd.service;

import bigdemo.bd.mapper.StuAdminMapper;
import bigdemo.bd.model.StuAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
用户自定义的Relam，用于认证和授权
 */
public class CustomRelam extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(CustomRelam.class);

    private static final Long sessionKeyTimeOut = 30_000L;

    @Autowired
    private StuAdminMapper stuAdminMapper;

    /*
    授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("未授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermission("user:select");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();

        StuAdmin current= (StuAdmin) subject.getPrincipal();        //获取下方认证登陆的对象

        System.out.println(current.getPerms());
        //设置当前用户权限
        info.addStringPermission(current.getPerms());
        return info;
    }




    /*
    认证-登陆
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        String password=String.valueOf(token.getPassword());
        log.info("当前登录的用户名={}   密码={}",username,password);
        StuAdmin stuAdmin = stuAdminMapper.select(username);

        if(stuAdmin==null){
            throw new UnknownAccountException("用户名不存在");

        }
        if(!String.valueOf(stuAdmin.getStuPassword()).equals(password)){
            System.out.println(!stuAdmin.getStuPassword().equals(password));
            throw new IncorrectCredentialsException("用户名密码不匹配");
        }

        SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(stuAdmin,password,"");
        setSession("sid",String.valueOf(stuAdmin.getStuId()));
        return info;
    }

    /*
    将key与对应的value放入到对应的session中,最终交给httpsession进行管理，如果是分布式则交给redis-session管理
     */
    private void setSession(String key,String value){
        Session session=SecurityUtils.getSubject().getSession();
        if(session!=null){
            session.setAttribute(key,value);
            session.setTimeout(sessionKeyTimeOut);
        }
    }
}
