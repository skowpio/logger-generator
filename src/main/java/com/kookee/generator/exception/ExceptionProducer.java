package com.kookee.generator.exception;


import java.util.Random;

public enum ExceptionProducer implements ExceptionGenerator{
    ARITHMETIC(new ArithmeticExceptionGenerator()),
    OUT_OF_BOUNDS(new OutOfBoundsExceptionGenerator()),
    NULLPOINTER(new NullPointerExceptionGenerator()),
    JDBC(new JDBCExceptionGenerator());

    private ExceptionGenerator exceptionGenerator;

    ExceptionProducer(ExceptionGenerator exceptionGenerator) {
        this.exceptionGenerator = exceptionGenerator;
    }

    public void generate() {
            exceptionGenerator.generate();
    }

    public static void generateRandom() {
        ExceptionGenerator random = ExceptionProducer.values()[new Random().nextInt(ExceptionProducer.values().length)];
        random.generate();
    }
}
