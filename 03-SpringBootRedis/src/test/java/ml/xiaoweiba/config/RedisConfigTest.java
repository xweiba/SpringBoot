package ml.xiaoweiba.config;

import java.util.concurrent.TimeUnit;

import ml.xiaoweiba.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootTest
public class RedisConfigTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        Student student = new Student("aa", 24, "aa@126.com", "213321");
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        operations.set("students", student);
        operations.set("studentOne", student, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("studentOne");
        boolean exists = redisTemplate.hasKey("students");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        System.out.println(operations.get("students").getStudentName());
        Assert.assertEquals("aa", operations.get("students").getStudentName());
    }
}