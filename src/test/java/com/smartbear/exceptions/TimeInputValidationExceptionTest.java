package com.smartbear.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;

public class TimeInputValidationExceptionTest {

    @Test
    public void testClass_whenMessageProvidedShouldSetMessage() {
        String errorMessage = RandomStringUtils.randomAlphabetic(10);
        TimeInputValidationException exception = new TimeInputValidationException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testClass_whenMessageProvidedIsNullShouldSetNullMessage() {

        TimeInputValidationException exception = new TimeInputValidationException(null);
        assertEquals(null, exception.getMessage());
    }
}
