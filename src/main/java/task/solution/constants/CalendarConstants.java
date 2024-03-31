package task.solution.constants;

import java.time.Month;
import java.util.List;
import java.util.Map;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;

public class CalendarConstants {
    public static final Map<Month, List<Integer>> HOLIDAY_DATES = Map.of(
            JANUARY, List.of(1, 2, 3, 4, 5, 6, 7, 8),
            FEBRUARY, List.of(23),
            MARCH, List.of(8),
            MAY, List.of(1, 9),
            JUNE, List.of(12),
            NOVEMBER, List.of(4));

    public static final int HOLIDAYS_COUNT = 14;

    public static final int DAYS_IN_YEAR = 365;

    public static final int MONTHS_COUNT = 12;

    public static final double AVERAGE_DAYS_COUNT_IN_MONTH = (double) (DAYS_IN_YEAR - HOLIDAYS_COUNT) / MONTHS_COUNT;
}
