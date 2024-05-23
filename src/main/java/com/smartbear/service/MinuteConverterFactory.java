package com.smartbear.service;

public class MinuteConverterFactory implements TimeConverterFactory<Integer, Integer> {
    @Override
    public TimeConverterStrategy<Integer, Integer> createStrategy() {
        return new MinuteConverterStrategy();
    }
}
