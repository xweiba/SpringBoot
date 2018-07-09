package ml.xiaoweiba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: demo
 * @description: User 事务测试实体类
 * @author: Mr.xweiba
 * @create: 2018-06-29 17:34
 **/
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    // 添加效验 这个是在新建表的时候写入的,
    // 也就是说如果你使用的老表, 新加的这个属性并不会生效. 可以更改 Hibernate的spring.jpa.hibernate.ddl-auto 参数.
    // 或者去数据库手动更改
    @Column(nullable = false, length = 5)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
