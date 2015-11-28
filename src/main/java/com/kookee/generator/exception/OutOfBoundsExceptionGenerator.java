package com.kookee.generator.exception;

/**
 * Created by kuki on 2015-11-01.
 */
public class OutOfBoundsExceptionGenerator implements  ExceptionGenerator {
    public void generate() {
        int[] a = {};
        int b = a[1];
    }
}
