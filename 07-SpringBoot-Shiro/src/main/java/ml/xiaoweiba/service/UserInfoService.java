package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.UserInfo;

/**
 * @program: demo
 * @description:
 * @author: Mr.xweiba
 * @create: 2018-07-02 02:00
 **/

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
