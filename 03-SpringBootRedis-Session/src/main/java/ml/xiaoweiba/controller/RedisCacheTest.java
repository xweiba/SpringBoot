package ml.xiaoweiba.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.UUID;


/**
 * @program: demo
 * @description: Redis 缓存测试
 * @author: Mr.xweiba
 * @create: 2018-06-23 15:04
 **/

@RestController
public class RedisCacheTest {
    @RequestMapping(value = "/uid2")
    public String uid2(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid==null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println("erwewq");
        return session.getId();
    }
}
