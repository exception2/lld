package com.satyendra.lld.chainOfResponsibility.loggingSystem;

public class LoggingClient {

    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogLevel.INFO, "info logger");
        logProcessor.log(LogLevel.DEBUG, "info logger");
        logProcessor.log(LogLevel.ERROR, "info logger");
        logProcessor.log(LogLevel.WARN, "info logger");
    }
}
