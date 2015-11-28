package com.kookee.generator.exception;

public class NullPointerExceptionGenerator implements ExceptionGenerator{


    public void generate() {
        Integer a = null;
        double b = a.doubleValue();

    }
}
