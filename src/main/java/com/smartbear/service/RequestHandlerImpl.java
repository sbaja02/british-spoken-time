package com.smartbear.service;


import com.smartbear.exceptions.TimeInputValidationException;

public class RequestHandlerImpl implements RequestHandler {

    private final RequestReader inputReader;
    private final RequestValidator requestValidator;
    private final RequestProcessor requestProcessor;

    public RequestHandlerImpl(RequestReader inputReader, RequestValidator requestValidator,
                              RequestProcessor requestProcessor) {
        this.inputReader = inputReader;
        this.requestValidator = requestValidator;
        this.requestProcessor = requestProcessor;
    }

    public void takeInput() throws Exception {
        String input = inputReader.read();
        try {
            requestValidator.validate(input);
        } catch (TimeInputValidationException timeInputValidationException) {
            throw new TimeInputValidationException(timeInputValidationException.getMessage());
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(runtimeException.getMessage());
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
        requestProcessor.process(input);
    }
}
