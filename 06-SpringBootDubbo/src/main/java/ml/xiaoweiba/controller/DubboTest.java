package ml.xiaoweiba.controller;

import com.reger.dubbo.annotation.Inject;
import ml.xiaoweiba.service.ComputeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: Dubbo 测试控制器
 * @author: Mr.xweiba
 * @create: 2018-06-30 16:14
 **/

@RestController
public class DubboTest {
    // 使用Dubbo注解来实现远程对象注入
    @Inject
    private ComputeService computeService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return String.valueOf(computeService.add(1,3));
    }
}
