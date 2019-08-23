package com.kylin.demo.util;

import java.util.concurrent.*;

/**
 * @Classname ScheduleUtil
 * @Description TODO
 * @Date 2019-08-20 23:26
 * @Created by zhangbinbin
 */
public class ScheduleUtil {

    static final ScheduledExecutorService scheduleExec = Executors.newScheduledThreadPool(2);
    public <V> ScheduledFuture<V> schedule(final Callable<V> callable, final long delay, final TimeUnit unit) {
        return scheduleExec.schedule(callable, delay, unit);
    }

    public static ScheduledFuture<?> scheduleWithFixedRate(final Runnable command, final long initialDelay,
                                                    final long period, final TimeUnit unit) {
        return scheduleExec.scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(final Runnable command, final long initialDelay,
                                                     final long delay, final TimeUnit unit) {
        return scheduleExec.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

    static {
        Thread shutdownThread = new Thread("destroyAsyncExecutorThread") {
            @Override
            public void run() {
                try {
                    scheduleExec.shutdown();
                    scheduleExec.awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Runtime.getRuntime().addShutdownHook(shutdownThread);
        System.out.println("hook");
    }

}
