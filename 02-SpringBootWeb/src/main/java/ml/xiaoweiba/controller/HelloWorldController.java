package ml.xiaoweiba.controller;

import ml.xiaoweiba.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description: Spring Boot Controller测试类
 * @author: Mr.xweiba
 * @create: 2018-06-20 17:56
 **/

@RestController
public class HelloWorldController {
    @Resource
    User user;
    @RequestMapping("/getUser")
    public User getUser(){
        System.out.println(user.getiAge()+ user.getsUsername());
       /* user.setiAge(12);
        user.setsUsername("流哈哈");*/
        return user;
    }
}
