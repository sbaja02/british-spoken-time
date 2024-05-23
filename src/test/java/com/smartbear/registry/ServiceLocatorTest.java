package com.smartbear.registry;

import com.smartbear.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceLocatorTest {

    @Test
    public void testGetService_InputReader_Correct() {
        RequestReader actual = ServiceLocator.getService(RequestReader.class);
        assertNotNull(actual);
        assertTrue(actual instanceof RequestReader);
    }

    @Test
    void testGetService_InputRequestValidator_Correct() {
        RequestValidator actual = ServiceLocator.getService(RequestValidator.class);
        assertNotNull(actual);
        assertTrue(actual instanceof RequestValidator);
    }

    @Test
    void testGetService_TimeToWordConversion_Correct() {
        RequestProcessor actual = ServiceLocator.getService(RequestProcessor.class);
        assertNotNull(actual);
        assertTrue(actual instanceof RequestProcessor);
    }

    @Test
    public void testGetService_HourConverterFactory_Correct() {
        HourConverterFactory actual = ServiceLocator.getService(HourConverterFactory.class);
        assertNotNull(actual);
        assertTrue(actual instanceof HourConverterFactory);
    }

    @Test
    void testGetService_MinuteConverterFactory_Correct() {
        MinuteConverterFactory actual = ServiceLocator.getService(MinuteConverterFactory.class);
        assertNotNull(actual);
        assertTrue(actual instanceof MinuteConverterFactory);
    }

    @Test
    void testGetService_RequestHandler_Correct() {
        RequestHandler actual = ServiceLocator.getService(RequestHandler.class);
        assertNotNull(actual);
        assertTrue(actual instanceof RequestHandler);
    }

    @Test
    void testGetService_VerbalTimeConvertor_Correct() {
        VerbalTimeConvertor actual = ServiceLocator.getService(VerbalTimeConvertor.class);
        assertNotNull(actual);
        assertTrue(actual instanceof VerbalTimeConvertor);
    }

    @Test
    void testGetService_UnregisteredService_Negative() {
        Object actual = ServiceLocator.getService(UnregisteredService.class);
        assertNull(actual);
    }

    @Test
    void testGetService_NullClass_Negative() {
        Object actual = ServiceLocator.getService(null);
        assertNull(actual);
    }

    @Test
    void testGetService_InterfaceNotImplemented_Negative() {
        Object actual = ServiceLocator.getService(InterfaceNotImplemented.class);
        assertNull(actual);
    }

    @Test
    void testGetService_InvalidInput_Negative() {
        Object actual = ServiceLocator.getService(String.class);
        assertNull(actual);
    }

    private interface UnregisteredService {}

    private interface InterfaceNotImplemented {}

}
