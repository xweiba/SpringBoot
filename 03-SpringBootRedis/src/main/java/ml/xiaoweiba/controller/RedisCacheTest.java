package ml.xiaoweiba.controller;


import ml.xiaoweiba.entity.Student;
import ml.xiaoweiba.service.StudentRepostiory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
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
    // 默认存进去的是map集合, 集合名为 keyName~keys,
    @Cacheable("keyName")
    public List<Student> getStudent(){
        List<Student> studenttest = studentRepostiory.findByStudentName("aa1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return studenttest;
    }
    @RequestMapping(value = "/cache/{keyName}")
    @Cacheable(cacheNames = "cacheNames", key = "#keyName", unless = "#keyName.equals('unless')")
    public List<Student> getnoaa1(@PathVariable String keyName) {
        List<Student> studentList = studentRepostiory.findByStudentName("aa1");
        System.out.println("DB查询 执行了");
        return studentList;
    }

    @RequestMapping(value = "/cache/{keyName}")
    @Cacheable(cacheNames = "cacheNames", key = "#keyName", sync = true)
    public Student get(@PathVariable String keyName) {
        Student student = studentRepostiory.findOne(1L);
        System.out.println("DB查询 执行了");
        return student;
    }

    @RequestMapping(value = "/cache2/{keyName}")
    @CachePut(cacheNames = "cacheNames", key = "#keyName")
    public Student getcache2(@PathVariable String keyName) {
        Student student = studentRepostiory.findOne(2L);
        System.out.println("@CachePut 方法 执行了");
        return student;
    }

    @RequestMapping(value = "/cache/reload/{keyName}")
    @CacheEvict(cacheNames = "cacheNames", key = "#keyName")
    public void cacheReload(@PathVariable String keyName) {
        System.out.println("@CacheEvict 方法 执行了");
    }

    @RequestMapping(value = "/cache/reloadAll")
    @CacheEvict(cacheNames = "cacheNames", allEntries = true)
    public void cacheReloadAll() {
        System.out.println("cacheReloadAll 方法 执行了");
    }


    @RequestMapping(value = "/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid==null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println("erwewq");
        return session.getId();
    }
}
