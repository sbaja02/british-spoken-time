package com.smartbear.service;

import com.smartbear.exceptions.TimeInputValidationException;
import org.apache.commons.lang3.StringUtils;

public class RequestProcessorImpl<T> implements RequestProcessor<T> {

    private final VerbalTimeConvertor verbalTimeConvertor;

    public RequestProcessorImpl(VerbalTimeConvertor verbalTimeConvertor) {
        this.verbalTimeConvertor = verbalTimeConvertor;
    }

    @Override
    public void process(T input) {
        if(null == input || StringUtils.isEmpty((String) input)) {
            throw new TimeInputValidationException("Time cannot be empty.");
        }
        String time = (String) input;
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        System.out.println(verbalTimeConvertor.convertToVerbalTime(hour, minute));
    }
}
