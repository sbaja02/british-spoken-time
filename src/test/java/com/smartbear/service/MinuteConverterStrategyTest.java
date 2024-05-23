package com.smartbear.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinuteConverterStrategyTest {

    @Test
    public void convert_whenMinuteIsLessThan31_ReturnsCorrectTextualRepresentation() {
        MinuteConverterStrategy strategy = new MinuteConverterStrategy();

        assertEquals("", strategy.convert(1, 0));
        assertEquals("five", strategy.convert(1, 5));
        assertEquals("ten", strategy.convert(1, 10));
        assertEquals("fifteen", strategy.convert(1, 15));
        assertEquals("twenty", strategy.convert(1, 20));
        assertEquals("twenty one", strategy.convert(1, 21));
        assertEquals("thirty", strategy.convert(1, 30));

    }

    @Test
    public void convert_whenMinuteIsGreaterThan30_ReturnsCorrectTextualRepresentation() {
        MinuteConverterStrategy strategy = new MinuteConverterStrategy();

        assertEquals("twenty five", strategy.convert(1, 35));
        assertEquals("twenty", strategy.convert(1, 40));
        assertEquals("fifteen", strategy.convert(1, 45));
        assertEquals("ten", strategy.convert(1, 50));
        assertEquals("five", strategy.convert(1, 55));
        assertEquals("", strategy.convert(1, 60));
    }

    @Test
    public void convert_InvalidHour_ReturnsCorrectTextualRepresentation() {
        MinuteConverterStrategy strategy = new MinuteConverterStrategy();
        assertEquals("", strategy.convert(-1, 0));
        assertEquals("fifteen", strategy.convert(null, 15));
        assertEquals("", strategy.convert(24, 0));
    }

    @Test
    public void convert_EdgeCases_ReturnsCorrectTextualRepresentation() {
        MinuteConverterStrategy strategy = new MinuteConverterStrategy();

        assertEquals("", strategy.convert(1, 0));
        assertEquals("one", strategy.convert(1, 1));
        assertEquals("nine", strategy.convert(1, 9));
        assertEquals("ten", strategy.convert(1, 10));
        assertEquals("eleven", strategy.convert(1, 11));
        assertEquals("nineteen", strategy.convert(1, 19));
        assertEquals("twenty", strategy.convert(1, 20));
        assertEquals("twenty one", strategy.convert(1, 21));
        assertEquals("twenty nine", strategy.convert(1, 29));
        assertEquals("thirty", strategy.convert(1, 30));
        assertEquals("thirty one", strategy.convert(1, 31));
        assertEquals("thirty nine", strategy.convert(1, 39));
        assertEquals("twenty", strategy.convert(1, 40));
        assertEquals("forty one", strategy.convert(1, 41));
        assertEquals("forty nine", strategy.convert(1, 49));
        assertEquals("ten", strategy.convert(1, 50));
        assertEquals("fifty one", strategy.convert(1, 51));
        assertEquals("fifty nine", strategy.convert(1, 59));
    }
}
