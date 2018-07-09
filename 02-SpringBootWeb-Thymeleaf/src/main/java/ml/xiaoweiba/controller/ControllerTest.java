package ml.xiaoweiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: demo
 * @description: Controller 测试Thymeleaf
 * @autor: Mr.xweiba
 * @create: 2018-06-26 17:24
 **/
@Controller
public class ControllerTest {
    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
        // 向模板中添加数据
        modelMap.put("hello", "helloWeb");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
