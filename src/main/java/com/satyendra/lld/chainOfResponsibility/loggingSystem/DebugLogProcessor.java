package com.satyendra.lld.chainOfResponsibility.loggingSystem;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(LogLevel.DEBUG == logLevel) {
            System.out.println("Debug log message printer : " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
