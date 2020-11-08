package bigdemo.bd;

import bigdemo.bd.controller.ClassAdminController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
class BdApplicationTests {

    private static final Logger log= LoggerFactory.getLogger(BdApplicationTests.class);

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(new ClassAdminController()).build();
    }

    @Test
    public void test1() throws Exception{
        log.debug("测试get请求无参数......");

        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.get("/Class/selectClass").accept(MediaType.APPLICATION_JSON).param("page","1").param("limit","1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void test2() throws Exception{
        log.debug("测试get请求带参数......");

        String myName="debug-steadyjack-大圣";
        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.get("/Class/selectClasss_time").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }





}
