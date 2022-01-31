package aop.logtracer.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void 컨트롤러작동테스트() throws Exception {
        // given
        // when
        ResultActions perform = mockMvc.perform(get("/order").param("itemId", "1"));
        // then
        perform.andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }

    @Test
    public void 에러처리테스트() throws Exception {
        // given

        // when
        ResultActions perform = mockMvc.perform(get("/order").param("itemId", "ex"));
        // then
        perform.andExpect(status().is5xxServerError());
    }

}