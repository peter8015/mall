package com.macro.mall;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class JavaInstance {
    private final static int THEAD_COUNT = 10;
    private final static int ITERM_COUNT = 1000;


    @Test
    public void t1() {

        ConcurrentHashMap<String, Long> chm = getData(1000);

        for (ConcurrentHashMap.Entry<String, Long> entry : chm.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry
                    .getValue());
        }
        System.out.println();

    }

    /**
     * product a chm  with Long
     *
     * @param count
     * @return
     */
    private ConcurrentHashMap<String, Long> getData(int count) {
//        return LongStream.rangeClosed(1, count)     //return   1...count long value
//                .boxed()
//                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),
//                        Function.identity(),
//                        (o1, o2) -> o1,
//                        ConcurrentHashMap::new));

        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i ->
                        UUID.randomUUID().toString(),
                        Function.identity(),
                        (o1, o2) -> o1,
                        ConcurrentHashMap::new));
    }

    @Test
    public void testWrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITERM_COUNT - 100);
        System.out.println("init.size:" + concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THEAD_COUNT);

        Long start = System.currentTimeMillis();
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            synchronized (concurrentHashMap) {   //保障操作是原子的
                int gap = ITERM_COUNT - concurrentHashMap.size();
                System.out.println("gap size:" + gap);
                concurrentHashMap.putAll(getData(gap));

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("cost : " + (System.currentTimeMillis() - start) + " ms!");
        System.out.println("finish size : " + concurrentHashMap.size());
//        return "OK";
    }


    @Test
    public void test2() {
        //LongStream.rangeClosed
//        LongStream longStream = LongStream.rangeClosed(11, 22);
//        longStream.forEach(l -> System.out.print(l + " "));

        System.out.println(Function.identity());

    }
}




























