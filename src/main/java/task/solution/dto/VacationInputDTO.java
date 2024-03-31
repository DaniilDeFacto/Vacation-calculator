package task.solution.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class VacationInputDTO {
    private double averageSalary;
    private int vacationDays;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private List<LocalDate> vacationDates;
}
