package com.solvd.utils;

import java.time.OffsetDateTime;

public class DateFormatter {
    public static String getCurrentTime() {
        return OffsetDateTime.now().toString();

    }
}
