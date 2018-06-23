package ml.xiaoweiba.controller;


import ml.xiaoweiba.entity.Student;
import ml.xiaoweiba.service.StudentRepostiory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;


/**
 * @program: demo
 * @description: Redis 缓存测试
 * @author: Mr.xweiba
 * @create: 2018-06-23 15:04
 **/

@RestController
public class RedisCacheTest {
    @Resource
    private StudentRepostiory studentRepostiory;

    @RequestMapping(value = "/getStudent")
    // 存进去的是集合, 集合key 为 keyName~keys, 值为 方法返回的对象
    @Cacheable(value = "keyName")
    public List<Student> getStudent(){
        List<Student> student = studentRepostiory.findByStudentName("aa1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return student;
    }

    @RequestMapping(value = "/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid==null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
