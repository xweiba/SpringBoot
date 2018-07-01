package ml.xiaoweiba.dao;

import ml.xiaoweiba.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: demo
 * @description:
 * @author: Mr.xweiba
 * @create: 2018-07-02 02:00
 **/

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
