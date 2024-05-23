package com.smartbear.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MinuteConverterFactoryTest {

    @Test
    public void createStrategy_ReturnsMinuteConverterStrategy() {

        MinuteConverterStrategy mockStrategy = mock(MinuteConverterStrategy.class);
        MinuteConverterFactory factory = new MinuteConverterFactory() {
            @Override
            public TimeConverterStrategy<Integer, Integer> createStrategy() {
                return mockStrategy;
            }
        };
        TimeConverterStrategy<Integer, Integer> strategy = factory.createStrategy();
        assertEquals(mockStrategy, strategy);
    }
}
