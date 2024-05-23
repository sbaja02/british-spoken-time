package com.smartbear.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HourConverterFactoryTest {

    @Test
    public void createStrategy_ReturnsHourConverterStrategy() {

        HourConverterStrategy mockStrategy = mock(HourConverterStrategy.class);
        HourConverterFactory factory = new HourConverterFactory() {
            @Override
            public TimeConverterStrategy<Integer, Integer> createStrategy() {
                return mockStrategy;
            }
        };
        TimeConverterStrategy<Integer, Integer> strategy = factory.createStrategy();
        assertEquals(mockStrategy, strategy);
    }
}
