package ml.xiaoweiba.service.impl;

import ml.xiaoweiba.entity.User;
import ml.xiaoweiba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: UserService 实现类
 * @author: Mr.xweiba
 * @create: 2018-06-28 17:04
 **/

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    // Spring的JdbcTemplate是自动配置的，你可以直接使用@Autowired来注入到你自己的bean中来使用。
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(String name, String age) {
        jdbcTemplate.update("INSERT INTO USER(NAME, AGE) VALUE (?, ?)", name, age);
    }

    @Override
    public void deleteByName(Long id) {
        jdbcTemplate.update("DELETE FROM USER WHERE id = ?", id);
    }

    @Override
    public User findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE name = ?", User.class, name);
    }

    @Override
    public void updateByName(Long id, User user) {
        jdbcTemplate.update("UPDATE USER SET name = ?, age = ? WHERE id = ?", user.getName(), user.getAge(), id);
    }

    @Override
    public Integer getAllUser() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER", Integer.class);
    }

    @Override
    public void deleteAllUser() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}
