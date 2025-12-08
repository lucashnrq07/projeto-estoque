package com.lucas.projeto_estoque.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // construtor privado para impedir instância
    private DateUtils() {
    }

    // parse da string para LocalDate
    public static LocalDate parse(String dateStr) {
        try {
            return LocalDate.parse(dateStr, FMT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida! Formato correto: dd/MM/yyyy");
        }
    }

    // valida formato sem converter
    public static boolean isValidFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr, FMT);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
