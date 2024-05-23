package com.smartbear.service;

// Concrete Factory Implementations
public class HourConverterFactory implements TimeConverterFactory<Integer, Integer> {
    @Override
    public TimeConverterStrategy<Integer, Integer> createStrategy() {
        return new HourConverterStrategy();
    }
}
