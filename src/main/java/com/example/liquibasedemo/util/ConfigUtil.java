package com.example.liquibasedemo.util;

import java.util.concurrent.TimeUnit;

public class ConfigUtil {

    private static final long[] TIME_UNIT_SLOTS;
    private static final String[] TIME_UNITS_EN;
    private static final String[] TIME_UNITS_CN;
    static {
        TIME_UNIT_SLOTS = new long[]{TimeUnit.DAYS.toMillis(1L), TimeUnit.HOURS.toMillis(1L), TimeUnit.MINUTES.toMillis(1L), TimeUnit.SECONDS.toMillis(1L)};
        TIME_UNITS_EN = new String[]{"days", "hours", "minutes", "seconds", "millis"};
        TIME_UNITS_CN = new String[]{"天", "小时", "分钟", "秒", "毫秒"};
    }

    public static String millisToDuration(long millis) {
        for(int i = 0; i < TIME_UNIT_SLOTS.length; ++i) {
            double r = (double)millis / (double)TIME_UNIT_SLOTS[i];
            if (r >= 1.0) {
                if (millis % TIME_UNIT_SLOTS[i] == 0L) {
                    return String.format("%d %s", (long)r, TIME_UNITS_EN[i]);
                }

                return String.format("%.1f %s", r, TIME_UNITS_EN[i]);
            }
        }

        return String.format("%d %s", millis, TIME_UNITS_EN[TIME_UNITS_EN.length - 1]);
    }


    public static long parseLongOr(String s, long d3fault) {
        return parseLongOr(s, 10, d3fault);
    }

    public static long parseLongOr(String s, int radix, long d3fault) {
        if (s == null) {
            return d3fault;
        } else {
            try {
                return Long.parseLong(s, radix);
            } catch (NumberFormatException var5) {
                return d3fault;
            }
        }
    }

}
