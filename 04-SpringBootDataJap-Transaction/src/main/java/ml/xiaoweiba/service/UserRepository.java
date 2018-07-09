package ml.xiaoweiba.service;

import ml.xiaoweiba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserRepository extends JpaRepository<User, Long>{

    // value 事务管理器名称, 多个数据源时使用,  isolation 隔离级别, propagation 传播行为
    @Transactional(
            // value = "transactionManagerPrimary",
            isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)
    User findUserByName(String name);
}
