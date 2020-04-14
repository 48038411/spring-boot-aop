package com.soft1851.springboot.aop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class UserControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    //预加载内容，用来初始化对 HelloControllerMvc的模拟
    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void hello() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/admin")
                .param("userName", "guoruichang")
                .param("password","Qq480384111")
                .header("id", "1")
                .header("role_name", "admin"));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
                resultActions.andExpect(MockMvcResultMatchers.status().isOk());
                resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    void user() {
    }

    @Test
    void admin() {
    }
}