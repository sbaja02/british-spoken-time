package com.smartbear.registry;

import com.smartbear.service.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static final Map<Class<?>, Object> services = new HashMap<>();

    static {
        services.put(RequestReader.class, new RequestReader());
        services.put(RequestValidator.class, new RequestValidatorImpl());
        services.put(HourConverterFactory.class, new HourConverterFactory());
        services.put(MinuteConverterFactory.class, new MinuteConverterFactory());
        services.put(VerbalTimeConvertor.class, new VerbalTimeConvertorImpl(
                getService(HourConverterFactory.class),
                getService(MinuteConverterFactory.class)
        ));
        services.put(RequestProcessor.class, new RequestProcessorImpl(
                getService(VerbalTimeConvertor.class)
        ));
        services.put(RequestHandler.class, new RequestHandlerImpl(
                getService(RequestReader.class),
                getService(RequestValidator.class),
                getService(RequestProcessor.class)
        ));
    }

    public static <T> T getService(Class<T> clazz) {
        return (T) services.get(clazz);
    }
}
