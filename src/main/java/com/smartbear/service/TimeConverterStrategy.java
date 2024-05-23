package com.smartbear.service;

public interface TimeConverterStrategy<T, V> {
    String convert(T hour, V minute);
}
