package ml.xiaoweiba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: demo
 * @description: Dubbo 服务端启动类
 * @author: Mr.xweiba
 * @create: 2018-06-30 00:18
 **/

// 通过 lombok 直接使用日志
@Slf4j
@SpringBootApplication
// Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现项目服务启动的时候就去加载一些数据或做一些事情这样的需求。
public class ApplicationDubbo implements CommandLineRunner {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ApplicationDubbo.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("服务调用者------>>启动完毕");
    }
}

