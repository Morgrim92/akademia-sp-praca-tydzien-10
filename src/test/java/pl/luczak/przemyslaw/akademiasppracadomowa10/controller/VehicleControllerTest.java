package pl.luczak.przemyslaw.akademiasppracadomowa10.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.luczak.przemyslaw.akademiasppracadomowa10.model.Vehicle;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnVehiclesList() throws Exception {
        mockMvc.perform(get("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void shouldUpdateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "Audi", "A4", "Black");
        mockMvc.perform(put("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(vehicle)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model", Is.is(vehicle.getModel())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.color", Is.is(vehicle.getColor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vehicleBrand", Is.is(vehicle.getVehicleBrand())))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddNewVehicle() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "Audi", "A4", "Black");
        mockMvc.perform(post("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(vehicle)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model", Is.is(vehicle.getModel())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.color", Is.is(vehicle.getColor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vehicleBrand", Is.is(vehicle.getVehicleBrand())))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotRemoveNotExistingVehicle() throws Exception {
        mockMvc.perform(delete("/vehicles/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private String asJsonString(Vehicle vehicle) {
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(vehicle);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}