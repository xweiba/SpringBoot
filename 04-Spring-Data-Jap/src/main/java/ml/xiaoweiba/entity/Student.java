package ml.xiaoweiba.entity;

import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @program: demo
 * @description: 学生类
 * @author: Mr.xweiba
 * @create: 2018-06-26 11:46
 **/

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = -3147280063996734119L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = false)
    private String studentName;

    @Column(nullable = false, unique = false)
    private int age;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(nullable = false, unique = false)
    private String regTime;

    public Student(){
        this.studentName = "test";
        this.age = 23;
        this.email = "liuhuan";
        this.regTime = "2018年6月23日 下午03时24分57秒";
    }

    public Student(String studentName, int age, String email, String regTime) {
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegTime() {
        return regTime;
    }

    private void setRegTime() {
        this.regTime = String.valueOf(System.currentTimeMillis());
    }
}
