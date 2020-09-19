package com.thoughtworks.rslist.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RsControllerTest {

    @Autowired
    MockMvc mockMvc;
    //测试接口

    @Test
    void should_get_rs_list() throws Exception {
        //perform:发送一个请求
        mockMvc.perform(get("/rs/list"))
                .andExpect(status().isOk())
                .andExpect(content().string("[第一条事件, 第二条事件, 第三条事件]"));
    }

    @Test
    void should_get_one_rs_event_from_the_list() throws Exception {
        mockMvc.perform(get("/rs/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("第一条事件"));
        mockMvc.perform(get("/rs/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("第二条事件"));
        mockMvc.perform(get("/rs/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("第三条事件"));
    }

    @Test
    void should_get_rs_event_by_range() throws Exception {
        mockMvc.perform(get("/rs/list?start=1&end=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("[第一条事件, 第二条事件, 第三条事件]"));
    }
}