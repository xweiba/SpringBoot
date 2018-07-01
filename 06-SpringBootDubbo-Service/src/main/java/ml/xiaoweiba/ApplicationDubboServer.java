package ml.xiaoweiba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

/**
 * @program: demo
 * @description: Dubbo 服务端启动类
 * @author: Mr.xweiba
 * @create: 2018-06-30 00:18
 **/

@SpringBootApplication
@Slf4j
public class ApplicationDubboServer {

    // 让 Dubbo 一直循环执行.
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDubboServer.class, args);
        log.info("Dubbo 服务端启动");
    }
}
