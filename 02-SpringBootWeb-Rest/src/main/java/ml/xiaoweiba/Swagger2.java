package ml.xiaoweiba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: demo
 * @description: Swagger2 配置类
 * @author: Mr.xweiba
 * @create: 2018-06-28 02:22
 **/
@Configuration
// 开启Swagger2
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket cerateRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // api的相关信息
                .apiInfo(apiInfo())
                .select()
                // 添加Controller的目录即可, 它会自动扫描包下的Controller
                .apis(RequestHandlerSelectors.basePackage("ml.xiaoweiba.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // 目录说明
    private ApiInfo apiInfo() {
        Contact contact = new Contact("小尾巴", "http://liuhuan.ml", "xiaoweiba1028@gmail.com");
        return new ApiInfoBuilder()
                // 标题
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                // 服务条款
                .termsOfServiceUrl("http://liuhuan.ml")
                // 联系方式
                .contact(contact)
                // .contact("程序猿DD") 新版本 Swagger2 中已过时
                .version("1.0")
                .build();
    }
}
