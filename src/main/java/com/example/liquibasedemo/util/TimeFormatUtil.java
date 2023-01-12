package com.example.liquibasedemo.util;

import com.google.common.base.Optional;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatUtil {
    public static final ZoneId ZONE_ID_UTC = ZoneId.of("UTC");
    public static final ZoneId ZONE_ID_CST = ZoneId.of("Asia/Shanghai");

    public static DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String timeInCST(long millis, DateTimeFormatter formatter) {
        ZonedDateTime cst = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZONE_ID_CST);
        return formatter.format(cst);
    }
    public static String timeInUTC(long millis, DateTimeFormatter formatter) {
        ZonedDateTime utc = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZONE_ID_UTC);
        return formatter.format(utc);
    }

    public static Optional<Long> parseCST(String ts) {
        return parseCST(ts, DEFAULT_FORMATTER);
    }

    public static Optional<Long> parseCST(String ts, DateTimeFormatter formatter) {
        try {
            Instant instant = Instant.from(formatter.withZone(ZONE_ID_CST).parse(ts));
            return Optional.of(instant.toEpochMilli());
        } catch (DateTimeException var3) {
            return Optional.absent();
        }
    }
}
