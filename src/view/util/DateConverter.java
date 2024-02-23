package view.util;

import service.exception.InvalidDatePatternException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter {
    public static LocalDate formatDateStringByPattern(String dateString, String pattern) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(dateString, formatter);
        } catch(DateTimeParseException exception){
            throw new InvalidDatePatternException("Formato da data inválido", exception);
        }
    }

    public static String formatDateByPattern(LocalDate date, String pattern) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return date.format(formatter);
    }

    public static Integer calculateAge(LocalDate birthDate){
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }
}
