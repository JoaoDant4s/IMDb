package util;

import service.exception.InvalidDatePatternException;

import java.time.LocalDate;
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
}
