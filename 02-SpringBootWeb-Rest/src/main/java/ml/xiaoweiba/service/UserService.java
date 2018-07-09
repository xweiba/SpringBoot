package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.User;

public interface UserService {
    /**
     * @description 新建用户
     * @param: [name]
     * @param: [age]
     */
    void create(String name, String age);

    /**
     * @description 根据用户id删除用户
     * @param: [name]
     */
    void deleteByName(Long id);

    /**
     * @description 根据用户名查找用户
     * @param: [name]
     */
    User findByName(String name);

    /**
     * @description 根据用户id更新用户
     * @param: [name]
     */
    void updateByName(Long id, User user);

    /**
     * @description 获取用户总量
     */
    Integer getAllUser();

    /**
     * @description 删除所有用户
     * @param: []
     */
    void deleteAllUser();
}
