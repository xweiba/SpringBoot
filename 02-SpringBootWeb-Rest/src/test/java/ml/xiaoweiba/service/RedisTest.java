package ml.xiaoweiba.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: demo
 * @description: Srping boot Redis 测试
 * @author: Mr.xweiba
 * @create: 2018-06-28 22:56
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    // StringRedisTemplate就相当于RedisTemplate<String, String>的实现。
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 添加测试
    @Test
    public void addCache() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
}
