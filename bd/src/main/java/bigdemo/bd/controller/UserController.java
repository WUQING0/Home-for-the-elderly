package bigdemo.bd.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Environment env;

    /*
    跳转登录页
     */
    @RequestMapping(value = {"/toLogin","/unauth"})
    public String toLogin(){
        return "login";
    }

    /*
    真正的登陆认证
     */
    @RequestMapping(value = "/reallogin",method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request,ModelMap modelMap){
        System.out.println(username);
        String errorMsg = "";

        try {
            if(!SecurityUtils.getSubject().isAuthenticated()){
                String newPsd=new Md5Hash(password,env.getProperty("shiro.encrypt.password.salt")).toString();
                UsernamePasswordToken token =new UsernamePasswordToken(username,newPsd);
                SecurityUtils.getSubject().login(token);
            }
        }catch (UnknownAccountException e){
            return "redirect:http://localhost:8080/toLogin";

        }catch (IncorrectCredentialsException e){
            return "redirect:http://localhost:8080/toLogin";
        } catch (Exception e){
            return "redirect:http://localhost:8080/toLogin";
        }
        if(StringUtils.isBlank(errorMsg)){
            return "redirect:http://localhost:8080/student/index.html";     //认证成功后跳转
        }else{
            modelMap.addAttribute("errorMsg",errorMsg);
            return "/login";
        }
    }
    @RequestMapping(value = "/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping(value = "/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权无法访问此页面";
    }


}
