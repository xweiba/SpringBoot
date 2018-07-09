package ml.xiaoweiba.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.Thymeleaf;

/**
 * @program: demo
 * @description: Thymeleaf 测试
 * @author: Mr.xweiba
 * @create: 2018-06-28 01:52
 **/

@Controller
@Api(value = "Thymeleaf", tags = "Thymeleaf测试")
public class ThymeleafController {
    @ApiOperation(value = "Thymeleaf测试", httpMethod = "GET", response = Thymeleaf.class, notes = "Thymeleaf测试 跳转到 templates/hello.html ")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("host", "liuhuan.ml");
        return "hello";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
