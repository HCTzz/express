package com.xy.express.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @auther HHF
 * @create 2020-05-18 下午 8:32
 */
public class ThreadUtil {

    static class MyDefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyDefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "xy-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    private static ExecutorService ex =
            new ThreadPoolExecutor(2, 5, 2, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), new MyDefaultThreadFactory());

    public static ExecutorService getExector() {
        return ex;
    }

    /**
     * 执行无返回值任务
     * @param run
     */
    public static void exector(Runnable run){
        ex.execute(run);
    }

    /**
     *
     * @param call
     * @param <T>
     * @return
     */
    public static <T> T submit(Callable<T> call){
        return (T) ex.submit(call);
    }

}
