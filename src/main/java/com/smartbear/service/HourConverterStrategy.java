package com.smartbear.service;

// Concrete Strategies
public class HourConverterStrategy implements TimeConverterStrategy<Integer, Integer>{

    @Override
    public String convert(Integer hour, Integer minute) {
        String[] hourStrings = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve"
        };

        if (minute < 31 || minute % 5 != 0) {
            if (hour == 0 || hour == 12) {
                return hourStrings[11];
            } else if (hour > 12) {
                return hourStrings[hour % 12 - 1];
            } else {
                return hourStrings[hour - 1];
            }
        } else {
            if(hour > 12) {
                hour = hour % 12;
            }
            return hourStrings[hour];
        }
    }
}
