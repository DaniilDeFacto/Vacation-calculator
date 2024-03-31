package task.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import task.solution.dto.VacationInputDTO;
import task.solution.service.CalculatorService;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculate(@ModelAttribute VacationInputDTO data) {
        double vacationPay = calculatorService.getVacationPay(data);
        return ResponseEntity.ok(vacationPay);
    }
}
