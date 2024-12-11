package com.satyendra.lld.chainOfResponsibility.loggingSystem;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(LogLevel.ERROR == logLevel) {
            System.out.println("Error log message printer : " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
