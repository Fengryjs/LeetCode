package study.threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );
//        executor.execute();
    }
}
