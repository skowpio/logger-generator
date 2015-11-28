package com.kookee.generator.exception.wrapper;

import java.util.Random;

/**
 * Created by kuki on 2015-11-01.
 */
public class ExceptionWrapper {
    public Exception wrap(Exception e){
        Exception result = e;

        int randomDepth = new Random().nextInt(10);

        for(int i = 0; i<randomDepth; i++){
                result = new Exception(result);
        }

        return result;
    }
}
