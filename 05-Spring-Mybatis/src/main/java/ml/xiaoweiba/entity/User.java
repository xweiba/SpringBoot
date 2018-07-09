package ml.xiaoweiba.entity;

import java.io.Serializable;

/**
 * @program: demo
 * @description: 实体类
 * @author: Mr.xweiba
 * @create: 2018-06-29 11:30
 **/

public class User implements Serializable {
    private static final long serialVersionUID = -2386082866319223777L;


    private Long id;
    private String name;
    private Integer age;

    public User() {

    }

    // 自定义构造函数后一定要添加无参构造函数
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
