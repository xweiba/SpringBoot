package ml.xiaoweiba.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void getUserList() throws Exception {
        MockHttpServletRequestBuilder request = null;
        request = post("/user/");

        System.out.println("插入数据");
        // 提交三个User
        mvc.perform(
                request
                        .param("id", "1")
                        .param("name", "测试插入1")
                        .param("age", "24"));

        mvc.perform(
                post("/user/")
                        .param("id", "2")
                        .param("name", "测试插入2")
                        .param("age", "22"));
        String responseString = mvc.perform(
                post("/user/")
                        .param("id", "3")
                        .param("name", "测试插入3")
                        .param("age", "21")
        ).andDo(print()).andReturn().getResponse().getContentAsString();

        System.out.println(responseString);

        System.out.println("----");

        // 查询刚提交的
        responseString = mvc.perform(get("/user/")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
        System.out.println("----");
        // 修改id为1的数据
        mvc.perform(put("/user/1").param("name", "修改数据"));
        System.out.println(mvc.perform(get("/user/1")).andDo(print()).andReturn().getResponse().getContentAsString());
        System.out.println("----");
        // 删除id为2的数据
        System.out.println("delete(\"/user/2\" : " + mvc.perform(delete("/user/2")).andReturn().getResponse().getContentAsString());
        System.out.println("get(\"/user/\" : " + mvc.perform(get("/user/")).andReturn().getResponse().getContentAsString());
        System.out.println("----");
    }
}