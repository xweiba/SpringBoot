package ml.xiaoweiba.service.impl;

import ml.xiaoweiba.dao.UserInfoDao;
import ml.xiaoweiba.entity.UserInfo;
import ml.xiaoweiba.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @author: Mr.xweiba
 * @create: 2018-07-02 02:01
 **/

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
