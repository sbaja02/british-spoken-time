package com.smartbear.service;

public class MinuteConverterStrategy implements TimeConverterStrategy<Integer, Integer> {
    @Override
    public String convert(Integer hour, Integer minute) {
        if (minute == 0) {
            return "";
        }
        if(minute > 30 && minute % 5 == 0) {
            minute = 60 - minute;
        }
        if (minute < 10) {
            return getSingleDigitMinuteString(minute);
        } else if (minute < 20) {
            return getTeenMinuteString(minute);
        } else if (minute % 10 == 0) {
            return getMultipleOfTenMinuteString(minute);
        } else {
            return getMultipleOfTenMinuteString(minute - minute % 10) + " " + getSingleDigitMinuteString(minute % 10);
        }
    }

    public String getSingleDigitMinuteString(int minute) {
        String[] singleDigitMinuteStrings = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        return singleDigitMinuteStrings[minute];
    }

    public String getTeenMinuteString(int minute) {
        String[] teenMinuteStrings = {
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        return teenMinuteStrings[minute - 10];
    }

    public static String getMultipleOfTenMinuteString(int minute) {
        String[] multipleOfTenMinuteStrings = {
                "", "", "twenty", "thirty", "forty", "fifty"
        };
        return multipleOfTenMinuteStrings[minute / 10];
    }
}
