package ml.xiaoweiba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: demo
 * @description: Spring Security 安全控制配置类
 * @author: Mr.xweiba
 * @create: 2018-06-28 16:08
 **/

@Configuration
// 开启WebSecurity
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 重写设置类
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护
                .authorizeRequests()
                // 不需要权限即可访问的
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                // 通过formLogin()定义当需要用户登录时候，转到的登录页面。
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    // 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                // 添加测试用户名密码 并设置
                .withUser("user").password("password").roles("USER");
    }
}
