package com.smartbear.service;

public interface VerbalTimeConvertor<T> {
    String convertToVerbalTime(T hour, T minute);
}
