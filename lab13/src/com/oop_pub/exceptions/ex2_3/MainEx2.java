package com.oop_pub.exceptions.ex2_3;

import java.util.ArrayList;
import java.util.List;

public class MainEx2 {
    public static void main(String[] args) {
        // TODO: Initialize the calculator
        Calculator calculator = new Calculus();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

        // TODO: Test edge cases that would throw exceptions
        try {
            System.out.println(calculator.add(null, 0d));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.add(1d, Double.POSITIVE_INFINITY - 1));
        } catch (Calculator.OverflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.add(-1d, Double.NEGATIVE_INFINITY + 1));
        } catch (Calculator.UnderflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.divide(100d, null));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.divide(100d, 0d));
        } catch (ArithmeticException e) {
            System.out.println("divided by 0");
        }

        try {
            System.out.println(calculator.average(null));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.average(new ArrayList<>()));
        } catch (ArithmeticException e) {
            System.out.println("divided by 0");
        }

        /* pentru un utilizator care doreste sa foloseasca implementarile acestor functii
         * devine foarte enervat sa tot apeleze try-catch-uri la fiecare operatie;
         * consider ca era mai bine ca metodele sa nu arunce exceptii, ci se sa trateze direct,
         * tocmai pentru a nu-l obliga pe utilizator sa faca acest lucru.
         */
    }
}
