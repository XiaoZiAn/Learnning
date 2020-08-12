package com.xx.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author xiaoxinga
 * @date 2020/06/02 8:43
 * @since
 */
public class CompletableFutureTest {
    private Semaphore H = new Semaphore(2);
    private Semaphore O = new Semaphore(1);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            H.release(2);
            O.release();
        }
    });
    public static void main(String[] args) {
        CompletableFutureTest test = new CompletableFutureTest();
        for(int i=0;i<50;i++){
            test.outH2O();
            System.out.println();
        }
        try{
            test.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        /*//任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(() -> {
                    System.out.println("T1:洗水壶...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("T1:烧开水...");
                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });


        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("T2:洗茶壶...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("T2:洗茶杯...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("T2:拿茶叶...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "龙井";
                });
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf) -> {
                    System.out.println("T3:拿到茶叶:" + tf);
                    System.out.println("T3:泡茶...");
                    return "上茶:" + tf;
                });
        //等待任务3执行结果
        System.out.println(f3.join());


        CompletableFuture<Integer> f0 =
                CompletableFuture.supplyAsync(()->7/0).thenApply(r->r*10).exceptionally(e->0);
        System.out.println(f0.join());*/
    }

    public void outH2O(){
        Runnable releaseHydrogen = new Runnable() {
            @Override
            public void run() {
                System.out.print("H");
            }
        };
        Runnable releaseOxygen = new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };
        CompletableFuture<Void> fo = CompletableFuture.runAsync(releaseOxygen);
        CompletableFuture<Void> fh1 = CompletableFuture.runAsync(releaseHydrogen);
        CompletableFuture<Void> fh2 = CompletableFuture.runAsync(releaseHydrogen);
        CompletableFuture<Void> f = fo.runAfterBoth(fh1.runAfterBoth(fh2,()->{}), ()->{});
        f.join();
    }
}
