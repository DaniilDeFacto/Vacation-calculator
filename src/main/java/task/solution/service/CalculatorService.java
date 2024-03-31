package task.solution.service;

import org.springframework.stereotype.Service;
import task.solution.dto.VacationInputDTO;

import java.time.LocalDate;
import java.util.List;

import static task.solution.constants.CalendarConstants.AVERAGE_DAYS_COUNT_IN_MONTH;
import static task.solution.constants.CalendarConstants.HOLIDAY_DATES;


@Service
public class CalculatorService {
    public double getVacationPay(VacationInputDTO data) {
        return data.getVacationDates() == null
                ? simpleCalculate(data.getAverageSalary(), data.getVacationDays())
                : accurateCalculate(data.getAverageSalary(), data.getVacationDays(), data.getVacationDates());
    }

    private double simpleCalculate(double averageSalary, int vacationDays) {
        double vacationPayPerDay = round(averageSalary / AVERAGE_DAYS_COUNT_IN_MONTH);
        return round(vacationPayPerDay * vacationDays);
    }

    private double accurateCalculate(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        double vacationPayPerDay = round(averageSalary / AVERAGE_DAYS_COUNT_IN_MONTH);
        double totalVacationPay =  vacationPayPerDay * vacationDays;
        for (LocalDate vacationDate : vacationDates) {
            if (isHoliday(vacationDate)) {
                totalVacationPay -= vacationPayPerDay;
            }
        }
        return round(totalVacationPay);
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private static boolean isHoliday(LocalDate date) {
        return HOLIDAY_DATES.containsKey(date.getMonth())
                && HOLIDAY_DATES.get(date.getMonth()).contains(date.getDayOfMonth());
    }
}
