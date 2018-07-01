package ml.xiaoweiba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
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
public class ApplicationDubbo implements CommandLineRunner {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ApplicationDubbo.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.err.println("服务调用者------>>启动完毕");
    }
}

