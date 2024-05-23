package com.smartbear.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import com.smartbear.exceptions.TimeInputValidationException;

public class RequestHandlerImplTest {

    private RequestReader inputReader;
    private RequestValidator requestValidator;
    private RequestProcessor requestProcessor;
    private RequestHandlerImpl requestHandler;

    @BeforeEach
    void setUp() {
        inputReader = Mockito.mock(RequestReader.class);
        requestValidator = Mockito.mock(RequestValidator.class);
        requestProcessor = Mockito.mock(RequestProcessor.class);
        requestHandler = new RequestHandlerImpl(inputReader, requestValidator, requestProcessor);
    }

    @Test
    public void testTakeInput_whenInputIsValid_thenThrowsNoError() throws Exception {
        String validInput = "12:34";
        Mockito.when(inputReader.read()).thenReturn(validInput);
        assertDoesNotThrow(() -> requestHandler.takeInput());
        Mockito.verify(requestProcessor, Mockito.times(1)).process(validInput);
        Mockito.verify(requestValidator, Mockito.times(1)).validate(validInput);
    }

    @Test
    public void testTakeInput_whenInputIsInvalid_thenExceptionIsThrown() throws Exception {
        String invalidInput = "invalid_input";
        Mockito.when(inputReader.read()).thenReturn(invalidInput);
        Mockito.doThrow(new TimeInputValidationException("Invalid input format")).when(requestValidator).validate(invalidInput);
        assertThrows(TimeInputValidationException.class, () -> requestHandler.takeInput());
        Mockito.verify(requestValidator, Mockito.times(1)).validate(invalidInput);
        Mockito.verifyZeroInteractions(requestProcessor);
    }

    @Test
    public void testTakeInput_whenInputIsNull_thenThrowsNoError() throws Exception {
        String input = null;
        Mockito.when(inputReader.read()).thenReturn(input);
        assertDoesNotThrow(() -> requestHandler.takeInput());
        Mockito.verify(requestValidator, Mockito.times(1)).validate(input);
        Mockito.verify(requestProcessor, Mockito.times(1)).process(input);
    }

    @Test
    public void testTakeInput_RuntimeException() {
        String validInput = "12:34";
        Mockito.when(inputReader.read()).thenReturn(validInput);
        Mockito.doThrow(new RuntimeException("Something went wrong")).when(requestProcessor).process(validInput);
        assertThrows(RuntimeException.class, () -> requestHandler.takeInput());
        Mockito.verify(requestProcessor, Mockito.times(1)).process(validInput);
    }
}
