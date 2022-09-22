package de.neuefische.javatwitchicebreakergame.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void putQuestion() throws Exception {
        mockMvc.perform(
                        put("/api/questions/current")
                                .contentType(APPLICATION_JSON)
                                .content("{\"text\":\"Hello World\"}")
                ).andExpect(content().json("{\"text\":\"Hello World\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void getQuestion() throws Exception {
        mockMvc.perform(
                put("/api/questions/current")
                        .contentType(APPLICATION_JSON)
                        .content("{\"text\":\"Hello World\"}")
        ).andExpect(status().isOk());

        mockMvc.perform(
                get("/api/questions/current")
                        .contentType(APPLICATION_JSON)
                        .content("{\"text\":\"Hello World\"}")
        ).andExpect(content().json("{\"text\":\"Hello World\"}"));
    }
}