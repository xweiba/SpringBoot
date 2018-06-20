package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void setMvc() {
        // 启动Spring Boot
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getMvc() throws Exception {
        // perform 执行 ->
        // MockMvcRequestBuilders.get("/") 请求 ->
        // 接收数据accept, 格式为:MediaType.APPLICATION_JSON ->
        // 对比 andExpect(), 条件为: 返回状态码 status() 是否为正常获取: isOk() ->
        // 对比 andExpect(), 条件为: 返回内容 content() 是否为: string("Hello World").
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
}
