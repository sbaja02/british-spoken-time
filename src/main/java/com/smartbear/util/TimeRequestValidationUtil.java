package com.smartbear.util;

import com.smartbear.exceptions.TimeInputValidationException;

public class TimeRequestValidationUtil {

    public static final String TIME_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    public static void validateRequest(String time) {
        if(null == time || time.isEmpty()) {
            throw new TimeInputValidationException("Time cannot be empty.");
        }
        if(! time.matches(TIME_PATTERN)) {
            throw new TimeInputValidationException("Invalid time. Please enter time in the HH:MM format.");
        }
    }
}
