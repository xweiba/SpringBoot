package ml.xiaoweiba.config;

import ml.xiaoweiba.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() {
        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("黑寡妇", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("黑寡妇").getAge().longValue());
    }
}