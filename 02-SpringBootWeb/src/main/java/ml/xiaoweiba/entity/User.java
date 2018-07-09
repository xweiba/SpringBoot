package ml.xiaoweiba.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: demo
 * @description: 用户实体类
 * @author: Mr.xweiba
 * @create: 2018-06-20 18:09
 **/
@Component
public class User implements Serializable{
    private static final long serialVersionUID = 8667468581448787106L;

    @Value("${ml.xiaoweiba.entity.User.username}")
    private String sUsername;
    @Value("${ml.xiaoweiba.entity.User.age}")
    private int iAge;

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public int getiAge() {
        return iAge;
    }

    public void setiAge(int iAge) {
        this.iAge = iAge;
    }
}
