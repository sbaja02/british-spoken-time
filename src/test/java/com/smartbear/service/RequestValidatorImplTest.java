package com.smartbear.service;

import com.smartbear.exceptions.TimeInputValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestValidatorImplTest {

    private RequestValidator<String> requestValidator;

    @BeforeEach
    void setup() {
        requestValidator = new RequestValidatorImpl<>();
    }

    @Test
    public void testValidate_whenInputIsValid_noExceptionIsThrown() throws Exception {
        String input = "06:00";
        assertDoesNotThrow(() -> requestValidator.validate(input));
    }

    @Test
    public void testValidate_whenInputIsNull_TimeInputValidationExceptionIsThrown() throws Exception {
        assertThrows(TimeInputValidationException.class, () -> requestValidator.validate(null));
    }

    @Test
    public void testValidate_whenInputIsEmpty_TimeInputValidationExceptionIsThrown() throws Exception {
        assertThrows(TimeInputValidationException.class, () -> requestValidator.validate(null));
    }

    @Test
    public void testValidate_whenInputIsInvalid_TimeInputValidationExceptionIsThrown() throws Exception {
        assertThrows(TimeInputValidationException.class, () -> requestValidator.validate("invalid"));
    }

}