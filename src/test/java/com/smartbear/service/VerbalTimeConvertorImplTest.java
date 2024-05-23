package com.smartbear.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VerbalTimeConvertorImplTest {

    TimeConverterFactory<Integer, Integer> minuteConverterFactory;
    TimeConverterFactory<Integer, Integer> hourConverterFactory;
    TimeConverterStrategy<Integer, Integer> hourConverterStrategy;
    TimeConverterStrategy<Integer, Integer> minuteConverterStrategy;
    VerbalTimeConvertor<Integer> convertor;


    @BeforeEach
    public void setup() {
        hourConverterFactory = mock(TimeConverterFactory.class);
        minuteConverterFactory = mock(TimeConverterFactory.class);
        hourConverterStrategy = mock(TimeConverterStrategy.class);
        minuteConverterStrategy = mock(TimeConverterStrategy.class);
        when(hourConverterFactory.createStrategy()).thenReturn(hourConverterStrategy);
        when(minuteConverterFactory.createStrategy()).thenReturn(minuteConverterStrategy);
        convertor = new VerbalTimeConvertorImpl<>(hourConverterFactory, minuteConverterFactory);
    }


    @Test
    public void testConvertToVerbalTime_whenTimeIsFiveFifteen_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("five");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("fifteen");
        assertEquals("quarter past five", convertor.convertToVerbalTime(5, 15));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsOne_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("one");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("");
        assertEquals("one o'clock", convertor.convertToVerbalTime(1, 00));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsTwoFive_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("two");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("five");
        assertEquals("five past two", convertor.convertToVerbalTime(2, 05));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsThreeTen_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("three");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("ten");
        assertEquals("ten past three", convertor.convertToVerbalTime(3, 10));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsFourFifteen_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("four");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("fifteen");
        assertEquals("quarter past four", convertor.convertToVerbalTime(4, 15));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsFiveTwenty_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("five");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("twenty");
        assertEquals("twenty past five", convertor.convertToVerbalTime(5, 20));
    }

    @Test
    public void convertToVerbalTime_whenTimeIsSixTwentyFive_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("six");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("twenty five");
        assertEquals("twenty five past six", convertor.convertToVerbalTime(6, 25));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsSixThirtyTwo_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("six");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("thirty two");
        assertEquals("six thirty two", convertor.convertToVerbalTime(6, 32));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsSevenThirty_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("seven");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("thirty");
        assertEquals("half past seven", convertor.convertToVerbalTime(7, 30));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsSevenThirtyFive_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("eight");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("twenty five");
        assertEquals("twenty five to eight", convertor.convertToVerbalTime(7, 35));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsEightForty_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("nine");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("twenty");
        assertEquals("twenty to nine", convertor.convertToVerbalTime(8, 40));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsNineFortyFive_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("ten");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("forty five");

        assertEquals("quarter to ten", convertor.convertToVerbalTime(9, 45));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsTenFifty_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("eleven");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("ten");

        assertEquals("ten to eleven", convertor.convertToVerbalTime(10, 50));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsElevenFiftyFive_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("twelve");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("five");
        assertEquals("five to twelve", convertor.convertToVerbalTime(11, 55));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsMidnight_ReturnsCorrectVerbalTime() {
        assertEquals("midnight", convertor.convertToVerbalTime(00, 00));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsNoon_ReturnsCorrectVerbalTime() {
        assertEquals("noon", convertor.convertToVerbalTime(12, 00));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsOneThirteen_ReturnsCorrectVerbalTime() {

        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("one");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("thirteen");
        assertEquals("one thirteen", convertor.convertToVerbalTime(1, 13));
    }

    @Test
    public void testConvertToVerbalTime_whenTimeIsFourteenSeven_ReturnsCorrectVerbalTime() {
        when(hourConverterStrategy.convert(anyInt(), anyInt())).thenReturn("two");
        when(minuteConverterStrategy.convert(anyInt(), anyInt())).thenReturn("seven");
        assertEquals("two seven", convertor.convertToVerbalTime(14, 07));
    }

}