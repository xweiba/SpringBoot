package ml.xiaoweiba.controller;

import ml.xiaoweiba.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo
 * @description: 异常测试
 * @author: Mr.xweiba
 * @create: 2018-06-28 11:39
 **/
@Controller
public class ExceptionController {
    @RequestMapping("/exception")
    public String helloException() throws Exception{
        throw new Exception("exception 抛出异常");
    }

    @RequestMapping("/json")
    public String json() throws Exception{
        throw new MyException("json 发生了错误");
    }
}
