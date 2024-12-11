package com.satyendra.lld.chainOfResponsibility.loggingSystem;

public abstract class LogProcessor {

    LogProcessor nextLogProcessor;
    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(LogLevel logLevel, String message) {
        if(nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        } else {
            System.out.println("Log processor is null");
        }
    }
}
