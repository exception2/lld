package com.satyendra.lld.chainOfResponsibility.loggingSystem;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(LogLevel.INFO == logLevel) {
            System.out.println("Info log message printer : " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
