package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public abstract class LoggerBase {
    private final EnumSet<LogLevel> logLevels;
    private LoggerBase nextLoggerBase;

    public LoggerBase(EnumSet<LogLevel> logLevels) {
        this.logLevels = logLevels;
    }

    public void setNext(LoggerBase nextLoggerBase) {
        this.nextLoggerBase = nextLoggerBase;
    }

    protected abstract void writeMessage(String message);

    public void message(String message, LogLevel logLevel) {
        if (logLevels.contains(logLevel)) {
            writeMessage(message);
        }
        if (nextLoggerBase != null) {
            nextLoggerBase.message(message, logLevel);
        }
    }
}
