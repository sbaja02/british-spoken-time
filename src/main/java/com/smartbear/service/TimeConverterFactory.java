package com.smartbear.service;

public interface TimeConverterFactory<T,V> {
    TimeConverterStrategy<T,V> createStrategy();
}
