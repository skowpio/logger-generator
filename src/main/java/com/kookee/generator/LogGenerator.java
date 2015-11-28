package com.kookee.generator;

import com.kookee.generator.exception.ExceptionPool;
import com.kookee.generator.exception.ExceptionProducer;
import com.kookee.generator.exception.wrapper.ExceptionWrapper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class LogGenerator {

    private final static Logger LOG = Logger.getLogger(LogGenerator.class);
    private final static Priority[] priorities = {Priority.DEBUG, Priority.ERROR, Priority.FATAL, Priority.WARN, Priority.INFO};
    private final static int DEFAULT_RANDOMIZER = 7;
    private final static int DEFAULT_MULTIPLIER = 1;
    private final static int DEFAULT_LIMIT = 10;

    public static void main(String[] args) throws IOException {

        int multiplier = DEFAULT_MULTIPLIER;
        int randomizer = DEFAULT_RANDOMIZER;
        int limit = DEFAULT_LIMIT;

        if (args.length > 0) {
            File file = new File(args[0]);

            if(args.length > 1){
                multiplier = Integer.valueOf(args[1]);
            }

            if(args.length > 2){
                randomizer =  Integer.valueOf(args[2]);
            }

            if(args.length > 3){
                limit =  Integer.valueOf(args[3]);
            }

            ExceptionPool exceptionPool = new ExceptionPool(limit);
            ExceptionWrapper exceptionWrapper = new ExceptionWrapper();

            for(int x = 0; x < multiplier; x++) {
                List contents = FileUtils.readLines(file);
                int counter = 0;
                for (Object line : contents) {
                    logRandomLevel(line);
                    if (counter % (new Random().nextInt(randomizer) + 1) == 0) {
                        try {
                            if(exceptionPool.hasMore())
                                exceptionPool.generate();
                        } catch (Exception e) {
                            logRandomLevelThrowable(exceptionWrapper.wrap(e));
                        }
                    }
                    counter++;
                }
            }

            while (exceptionPool.hasMore()){
                try {
                        exceptionPool.generate();
                } catch (Exception e) {
                    logRandomLevelThrowable(exceptionWrapper.wrap(e));
                }
            }
        }
    }

    private static void logRandomLevel(Object wrap) {
        LOG.log(priorities[new Random().nextInt(priorities.length)], wrap);
    }

    private static void logRandomLevelThrowable(Throwable wrap) {
        LOG.log(priorities[new Random().nextInt(priorities.length)], wrap, wrap);
    }
}
