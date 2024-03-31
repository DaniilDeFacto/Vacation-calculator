package task.solution.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateWithoutDates() throws Exception {
        var request = get("/calculate")
                .param("averageSalary", "100000")
                .param("vacationDays", "20");
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        assertEquals("68376.0", body);
    }

    @Test
    public void testCalculateWithDatesWithoutHolidays() throws Exception {
        var request = get("/calculate")
                .param("averageSalary", "80000")
                .param("vacationDays", "7")
                .param("vacationDates", "30.03.2024",
                        "31.03.2024", "01.04.2024",
                        "02.04.2024", "03.04.2024",
                        "04.04.2024", "05.04.2024");
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        assertEquals("19145.28", body);
    }

    @Test
    public void testCalculateWithDatesWithHolidays() throws Exception {
        var request = get("/calculate")
                .param("averageSalary", "50000")
                .param("vacationDays", "15")
                .param("vacationDates", "29.04.2024",
                        "30.04.2024", "01.05.2024",
                        "02.05.2024", "03.05.2024",
                        "04.05.2024", "05.05.2024",
                        "06.05.2024", "07.05.2024",
                        "08.05.2024", "09.05.2024",
                        "01.11.2024", "02.11.2024",
                        "03.11.2024", "04.11.2024");
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        assertEquals("20512.8", body);
    }
}
