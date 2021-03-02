package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public interface Calculator {
    class NullParameterException extends RuntimeException {
        @Override
        public String getMessage() {
            return "one parameter is null";
        }
    }

    class UnderflowException extends RuntimeException {
        @Override
        public String getMessage() {
            return "result produces overflow";
        }
    }

    class OverflowException extends RuntimeException {
        @Override
        public String getMessage() {
            return "result produces underflow";
        }
    }

    Double add(Double nr1, Double nr2);

    Double divide(Double nr1, Double nr2);

    Double average(Collection<Double> numbers);
}
