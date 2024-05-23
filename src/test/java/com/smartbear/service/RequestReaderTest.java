package com.smartbear.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RequestReaderTest {

    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        String input = "07:14";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testRead_withInput() {
        RequestReader reader = new RequestReader();
        String result = reader.read();
        assertEquals("07:14", result);
    }

}