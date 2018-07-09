package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
// 添加事务注解后 只要有一条写入失败, 所有数据都会回滚. 不会写入
// @Transactional
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    // @Rollback 必须在 @Transactional 开启后才会生效
    @Rollback
    public void saveUser() throws Exception{
        userRepository.save(new User("AAA", 34));
        userRepository.save(new User("BBB", 66));
        userRepository.save(new User("CCC", 18));
        userRepository.save(new User("DDD", 24));
        userRepository.save(new User("EEE", 44));
        /* 添加一个 异常, 无效的话可能是User表未更新, 把user表删除 会自动重新生成 */
        /* 不加事务 之前写入的数据会正常写入, 这条会报异常 */
        userRepository.save(new User("EEEEEEEEE", 78));
        userRepository.save(new User("FFF", 14));
        userRepository.save(new User("GGG", 54));
        userRepository.save(new User("HHH", 94));
    }

    @Test
    public void findUser() {
        userRepository.findUserByName("GGG");
        // userRepository.findAll();
    }
}