package com.smartbear.service;

public class VerbalTimeConvertorImpl<T> implements VerbalTimeConvertor<T>{

    private final TimeConverterFactory<T,T> hourConverterFactory;
    private final TimeConverterFactory<T,T > minuteConverterFactory;

    public VerbalTimeConvertorImpl(TimeConverterFactory<T, T> hourConverterFactory,
                                   TimeConverterFactory<T, T> minuteConverterFactory) {
        this.hourConverterFactory = hourConverterFactory;
        this.minuteConverterFactory = minuteConverterFactory;
    }

    @Override
    public String convertToVerbalTime(T hour, T minute) {
        Integer hours = (Integer) hour;
        Integer minutes = (Integer) minute;

        if (hours == 0 && minutes == 0) {
            return "midnight";
        } else if (hours == 12 && minutes == 0) {
            return "noon";
        }

        TimeConverterStrategy<T,T> hourConverter = hourConverterFactory.createStrategy();
        TimeConverterStrategy<T,T> minuteConverter = minuteConverterFactory.createStrategy();

        String hourString = hourConverter.convert(hour, minute);
        String minuteString = minuteConverter.convert(hour, minute);

        if (minutes % 5 == 0) {
            if (minutes == 0) {
                return hourString + " o'clock";
            } else if (minutes == 15) {
                return "quarter past " + hourString;
            } else if (minutes == 30) {
                return "half past " + hourString;
            } else if (minutes < 30) {
                return minuteString  + " past " + hourString;
            } else if (minutes == 45) {
                return "quarter to " + hourString;
            } else {
                return minuteString + " to " + hourString;
            }
        } else {
            return hourString + " " + minuteString;
        }
    }
}
