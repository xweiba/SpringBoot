package ml.xiaoweiba.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @program: demo
 * @description: SessionConfig
 * @author: Mr.xweiba
 * @create: 2018-06-23 16:08
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

}
