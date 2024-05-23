package com.smartbear.service;

public interface RequestValidator<T> {
    void validate(T input) throws Exception;
}
