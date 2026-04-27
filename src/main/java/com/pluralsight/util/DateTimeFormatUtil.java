package com.pluralsight.util;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatUtil {

    // Date formats
    public static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Time formats
    public static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss");
}
