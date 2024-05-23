package com.smartbear.service;

import com.smartbear.exceptions.TimeInputValidationException;
import com.smartbear.util.TimeRequestValidationUtil;

public class RequestValidatorImpl<T> implements RequestValidator<T> {

    @Override
    public void validate(T input) throws Exception {
        String time = null;
        try {
            time = (String) input;
            TimeRequestValidationUtil.validateRequest(time);
        } catch (TimeInputValidationException timeInputValidationException) {
            throw new TimeInputValidationException(timeInputValidationException.getMessage());
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

}
