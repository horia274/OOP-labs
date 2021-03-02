package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class Calculus implements Calculator {
    @Override
    public Double add(Double nr1, Double nr2) throws RuntimeException {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }
        double sum = nr1 + nr2;
        if (sum == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }
        if (sum == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
        return nr1 + nr2;
    }

    @Override
    public Double divide(Double nr1, Double nr2) throws RuntimeException {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }
        if (nr2 == 0) {
            throw new ArithmeticException();
        }
        return nr1 / nr2;
    }

    @Override
    public Double average(Collection<Double> numbers) throws RuntimeException {
        double sum = 0;
        if (numbers == null) {
            throw new NullParameterException();
        }
        for (double number : numbers) {
            sum = add(sum, number);
        }
        return divide(sum, (double) numbers.size());
    }
}
