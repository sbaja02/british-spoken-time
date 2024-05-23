package com.smartbear.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HourConverterStrategyTest {

    @Test
    public void convert_whenValidInputs_ReturnsCorrectTextualRepresentation() {
        HourConverterStrategy strategy = new HourConverterStrategy();

        assertEquals("one", strategy.convert(1, 0));
        assertEquals("five", strategy.convert(5, 15));
        assertEquals("twelve", strategy.convert(12, 30));
        assertEquals("two", strategy.convert(13, 45));

        assertEquals("twelve", strategy.convert(0, 0));
        assertEquals("one", strategy.convert(1, 59));
        assertEquals("one", strategy.convert(13, 0));
        assertEquals("twelve", strategy.convert(12, 59));
    }

    @Test
    public void convert_whenInvalidHour_ReturnsValid() {
        HourConverterStrategy strategy = new HourConverterStrategy();
        assertEquals("eleven", strategy.convert(155, 00));
    }

    @Test
    public void convert_whenInvalidMinuteGreaterThan30_ReturnsValid() {
        HourConverterStrategy strategy = new HourConverterStrategy();

        assertEquals("one", strategy.convert(1, -1));
        assertEquals("two", strategy.convert(1, 60));
    }
}
