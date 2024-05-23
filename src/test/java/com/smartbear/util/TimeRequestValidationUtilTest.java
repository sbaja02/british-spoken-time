package com.smartbear.util;

import com.smartbear.exceptions.TimeInputValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeRequestValidationUtilTest {

    @Test
    public void testValidateRequest_whenTimeIsValid() {
        String validTime = "12:30";
        assertDoesNotThrow(() -> TimeRequestValidationUtil.validateRequest(validTime));
    }

    @Test
    public void testValidateRequest_whenTimeIsNull() {
        TimeInputValidationException exception = assertThrows(TimeInputValidationException.class,
                () -> TimeRequestValidationUtil.validateRequest(null));

        assertEquals("Time cannot be empty.", exception.getMessage());
    }

    @Test
    public void testValidateRequest_whenTimeIsEmpty() {
        TimeInputValidationException exception = assertThrows(TimeInputValidationException.class,
                () -> TimeRequestValidationUtil.validateRequest(""));

        assertEquals("Time cannot be empty.", exception.getMessage());
    }

    @Test
    public void testValidateRequest_WhenHourIsInvalid() {
        String invalidTime = "25:00";
        TimeInputValidationException exception = assertThrows(TimeInputValidationException.class,
                () -> TimeRequestValidationUtil.validateRequest(invalidTime));

        assertEquals("Invalid time. Please enter time in the HH:MM format.", exception.getMessage());
    }

    @Test
    public void testValidateRequest_WhenMinuteIsInvalid() {
        String invalidTime = "12:60";
        TimeInputValidationException exception = assertThrows(TimeInputValidationException.class,
                () -> TimeRequestValidationUtil.validateRequest(invalidTime));

        assertEquals("Invalid time. Please enter time in the HH:MM format.", exception.getMessage());
    }
}
