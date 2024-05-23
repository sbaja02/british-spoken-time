package com.smartbear.service;

public interface RequestProcessor<T> {
    void process(T input);
}
