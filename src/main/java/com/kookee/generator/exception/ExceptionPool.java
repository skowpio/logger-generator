package com.kookee.generator.exception;

public class ExceptionPool {
    private int limit;
    private int used = 0;

    public ExceptionPool(int limit) {
        this.limit = limit;
    }

    public boolean hasMore(){
        return limit >= used;
    }

    public void generate(){
            used++;
            ExceptionProducer.generateRandom();

    }
}
