package ml.xiaoweiba.service;

import com.reger.dubbo.annotation.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputeServiceTest {

    @Inject
    private ComputeService computeService;

    @Test
    public void add() {
        Assert.assertEquals("compute-service:add", new Integer(3), computeService.add(1, 2));
    }
}