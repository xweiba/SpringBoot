package ml.xiaoweiba.server;

import ml.xiaoweiba.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
// 开启事务后需要
@Transactional
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        System.out.println(userMapper.insert("CCC3", 20));
        User u = userMapper.findByName("CCC3");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    @Rollback
    public void insertMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "liuliu");
        map.put("age", 23);
        userMapper.inserMap(map);

        Assert.assertEquals(23, userMapper.findByName("liuliu").getAge().intValue());
    }

    @Test
    // 提交才会写入数据库
    @Commit
    // @Rollback
    public void insertUser() {
        User user = new User("haha", 77);
        userMapper.inserUser(user);
        userMapper.inserUser(user);
        userMapper.inserUser(user);
        User user1 = userMapper.findByName("321");
        System.out.println("user1 : " + user1.toString());
        Assert.assertEquals(77, userMapper.findByName("haha").getAge().intValue());
    }

    @Test
    @Rollback
    public void upDateUser() {
        User user = new User("CCC", 99);
        userMapper.update(user);
        Assert.assertEquals(99, userMapper.findByName("CCC").getAge().intValue());
    }

    @Test
    @Rollback
    public void deleteUser() {
        userMapper.delete("CCC");
        Assert.assertEquals(null, userMapper.findByName("CCC"));
    }

    @Test
    @Rollback
    public void findUsers() {
        List<User> userList = userMapper.findByNames("haha");
        Assert.assertEquals(77, userList.get(1).getAge().intValue());
    }
}