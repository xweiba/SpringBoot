package ml.xiaoweiba.service.impl;

import ml.xiaoweiba.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Before
    public void cleanUser(){
        userService.deleteAllUser();
    }

    @Test
    public void test() {
        userService.create("liu1", "1");
        userService.create("liu2", "2");
        userService.create("liu3", "3");
        userService.create("liu4", "4");

        Assert.assertEquals(4, userService.getAllUser().intValue());

        userService.deleteByName(17L);
        userService.deleteByName(18L);

        Assert.assertEquals(2, userService.getAllUser().intValue());

    }
}