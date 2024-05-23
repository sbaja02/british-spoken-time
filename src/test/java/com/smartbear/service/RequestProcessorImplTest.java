package com.smartbear.service;

import com.smartbear.exceptions.TimeInputValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RequestProcessorImplTest {

    private VerbalTimeConvertor verbalTimeConvertor;
    private RequestProcessor<String> processor;

    @BeforeEach
    void setup() {
        verbalTimeConvertor = Mockito.mock(VerbalTimeConvertor.class);
        processor = new RequestProcessorImpl<>(verbalTimeConvertor);
    }

    @Test
    public void testProcess_whenInputIsValid_thenVerbalTimeConvertorIsCalled() {
        String validInput = "08:49";
        processor.process(validInput);
        Mockito.verify(verbalTimeConvertor, Mockito.times(1)).convertToVerbalTime(8,49);
    }

    @Test
    public void testProcess_whenInputIsNull_thenTimeInputValidationExceptionIsThrown() {
        String input = null;
        assertThrows(TimeInputValidationException.class, () -> processor.process(input));
        Mockito.verifyZeroInteractions(verbalTimeConvertor);
    }

    @Test
    public void testProcess_whenInputIsEmpty_thenTimeInputValidationExceptionIsThrown() {
        String input = "";
        assertThrows(TimeInputValidationException.class, () -> processor.process(input));
        Mockito.verifyZeroInteractions(verbalTimeConvertor);
    }
}