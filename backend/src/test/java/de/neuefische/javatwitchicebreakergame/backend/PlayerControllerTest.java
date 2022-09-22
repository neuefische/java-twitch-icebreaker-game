package de.neuefische.javatwitchicebreakergame.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    public void postPlayer() throws Exception {
        mockMvc.perform(
                        post("/api/players")
                                .contentType(APPLICATION_JSON)
                                .content("{\"name\":\"Florian\"}")
                ).andExpect(content().json("{\"name\":\"Florian\"}"))
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    public void getPlayerList() throws Exception {
        mockMvc.perform(
                        post("/api/players")
                                .contentType(APPLICATION_JSON)
                                .content("{\"name\":\"Florian\"}")
                ).andExpect(content().json("{\"name\":\"Florian\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/players")
                        .contentType(APPLICATION_JSON)
        ).andExpect(content().json("[{\"name\":\"Florian\"}]"));
    }

    @Test
    @DirtiesContext
    public void deletePlayer() throws Exception {
        mockMvc.perform(
                        post("/api/players")
                                .contentType(APPLICATION_JSON)
                                .content("{\"name\":\"Florian\"}")
                ).andExpect(content().json("{\"name\":\"Florian\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(
                delete("/api/players/Florian")
                        .contentType(APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(
                get("/api/players")
                        .contentType(APPLICATION_JSON)
        ).andExpect(content().json("[]"));
    }
}
