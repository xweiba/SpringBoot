package ml.xiaoweiba.controller;

import io.swagger.annotations.*;
import ml.xiaoweiba.entity.User;
import ml.xiaoweiba.model.Msg;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @program: demo
 * @description: User 测试控制类
 * @author: Mr.xweiba
 * @create: 2018-06-27 21:25
 **/

@RestController
@RequestMapping(value = "/user")
@Api(value = "UserController", tags = "接口说明")
public class UserController {
    // 创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    // @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response = “接口返回参数类型”, notes = “接口发布说明”
    @ApiOperation(value = "获取用户列表", httpMethod = "GET", response = Msg.class , notes = "接口说明")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Msg getUserList() {
        return Msg.success().add("userList", new ArrayList<>(users.values()));
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Msg getUserList1() {
        return Msg.success().add("userList", new ArrayList<>(users.values()));
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    // @ApiImplicitParam(name = "user", value = "用户详细实体user", required = "是否唯一", dataTypeClass = "数据类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "String")
    })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Msg postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        System.out.println(user.toString());
        return Msg.success().add(String.valueOf(user.getId()), users);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Msg getUser(@PathVariable Long id){
        return Msg.success().add(String.valueOf(id), users.get(id));
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataTypeClass = Integer.class)
    })

    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Msg putUser(@PathVariable Long id, @ModelAttribute User user){
        User user1 = users.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.put(id, user1);
        return Msg.success().add(String.valueOf(id), users);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Msg delUser(@PathVariable Long id){
        users.remove(id);
        return Msg.fail().add(String.valueOf(id), users);
    }
}
