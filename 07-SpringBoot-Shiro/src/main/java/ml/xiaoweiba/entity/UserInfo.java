package ml.xiaoweiba.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @program: demo
 * @description: 用户信息表
 * @author: Mr.xweiba
 * @create: 2018-07-02 01:38
 **/

@Entity
// @Date 包含get set toString方法
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 8234935835923775054L;
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer uid;

    @Column(unique = true)
    @Getter @Setter
    private String username;    // 账号
    @Getter @Setter
    private String name;    // 名称（昵称或者真实姓名，不同系统不同定义）
    @Getter @Setter
    private String password; // 密码;
    @Getter @Setter
    private String salt;    // 加密密码的盐
    @Getter @Setter
    private byte state;     // 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    @Getter @Setter
    private List<SysRole> roleList;

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}