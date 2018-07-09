package ml.xiaoweiba.server;

import ml.xiaoweiba.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    // 使用map 传参
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int inserMap(Map<String, Object> map);

    // 直接使用对象
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int inserUser(User user);

    @Update("UPDATE user SET age=#{age} WHERE name = #{name}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE name = #{name}")
    void delete(String name);

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    // 返回结果绑定
    // 对于增、删、改操作相对变化较小。而对于“查”操作，我们往往需要进行多表关联，汇总计算等操作，那么对于查询的结果往往就不再是简单的实体对象了，往往需要返回一个与数据库实体不同的包装类，那么对于这类情况，就可以通过@Results和@Result注解来进行绑定，具体如下：

    @Results(
        {
            @Result(property = "name", column = "age"),
            @Result(property = "age", column = "age")
        }
    )
    @Select("select * from user where name = #{name}")
    List<User> findByNames(@Param("name") String name);
}
