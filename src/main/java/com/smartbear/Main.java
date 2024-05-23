package com.smartbear;

import com.smartbear.exceptions.TimeInputValidationException;
import com.smartbear.service.RequestHandler;
import com.smartbear.registry.ServiceLocator;

public class Main {

    public static void main(String[] args) {
        RequestHandler requestHandler = ServiceLocator.getService(RequestHandler.class);
        try {
            requestHandler.takeInput();
        } catch (TimeInputValidationException timeInputValidationException) {
            System.out.println(timeInputValidationException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("System seems to be down. Please try later.");
        } catch (Exception exception) {
            System.out.println("System seems to be down. Please try later.");
        }
    }
}
