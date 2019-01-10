package demo.kataapi.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil() {
        // util class
    }

    private static final DateTimeFormatter DATE_TIME_FORMATTER
        = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String reformDate(String dateInput) {
        return LocalDate.parse(dateInput, DATE_TIME_FORMATTER).format(DATE_TIME_FORMATTER);
    }
}
