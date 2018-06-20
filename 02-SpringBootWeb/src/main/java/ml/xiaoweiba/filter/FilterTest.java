package ml.xiaoweiba.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @program: demo
 * @description: Spring Boot Filter 过滤器测试
 * @author: Mr.xweiba
 * @create: 2018-06-20 19:44
 **/

@Configuration
public class FilterTest {
    @Bean
    // RemoteIpFilter https://www.ktanx.com/blog/p/4237
    // Tomcat容器过滤器, 通过将RemoteFilter这个过滤器加入过滤器调用链即可使用它。
    // 这里不使用它 Sping Boot 也能过滤到 MyFilter 过去器
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    // 注册过滤器
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 设置过滤器
        registrationBean.setFilter(new MyFilter());
        // 过滤 `/*` 请求, 过滤所有请求
        registrationBean.addUrlPatterns("/*");

        registrationBean.addInitParameter("paramName", "parnmValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            // 处理请求
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            // 对request、response进行一些预处理 还可以过滤不需要的字符
            servletResponse.setCharacterEncoding("UTF-8");
            servletRequest.setCharacterEncoding("UTF-8");

            System.out.println("调用service之前执行一段代码: this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("----调用service之后执行一段代码----");
        }

        @Override
        public void destroy() {

        }
    }
}
