package com.arthur.cur;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPool {
    /**
     * 核心线程数
     */
    private volatile int corePoolSize;

    /**
     * 最大线程数
     */
    private volatile int maximumPoolSize;

    /**
     * 线程在队列中存活的时间
     */
    private volatile long keepAliveTime;

    /**
     * 阻塞队列
     */
    private final BlockingQueue<Runnable> workQueue;

    /**
     * 拒绝策略，暂时写死
     */
    private final RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

    /**
     * workCount所占位数
     * 线程池实现中用int类型的高3位表示runState,低29位表示workCount
     */
    private static final int COUNT_BITS = Integer.SIZE - 3;

    /**
     * 最大线程数
     * 1左移29位减1相当于 2^29-1=536870911
     */
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    /**
     * 线程状态使用int类型的高3位存储
     */
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    /**
     * workers用<code>HashSet</code>保存
     * 所以向workers中添加元素需要用锁保证线程安全
     */
    private final ReentrantLock mainLock = new ReentrantLock();

    /**
     * 保存工作任务
     */
    private final HashSet<MyWorker> workers = new HashSet<>();

    /**
     * TODO 好像没什么软用
     */
    private int largetPoolSize;

    /**
     * 获取worker的数量，即int类型的低29位
     * @param c
     * @return
     */
    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    /**
     * 获取线程状态，即int类型高3位
     * @param c
     * @return
     */
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        if (corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize || keepAliveTime < 0) {
            throw new IllegalArgumentException();
        }

        if (workQueue == null) {
            throw new NullPointerException();
        }

        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.workQueue = workQueue;
    }

    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        int c = ctl.get();
        int workerCount = workerCountOf(c);
        if (workerCount < corePoolSize) {
            if (addWorker(command, true)) {
                return;
            }
        }
    }

    private boolean addWorker(Runnable firstTask, boolean core) {
        retry:
        for (;;) {
            int c = ctl.get();
            int rs = runStateOf(c);
            //判断当前线程池的状态
            //TODO 可能是在线程池终止时会修改状态，这段代码目前不理解
            if (rs >= SHUTDOWN && !(rs == SHUTDOWN && firstTask == null && !workQueue.isEmpty())) {
                return false;
            }

            for (;;) {
                int wc = ctl.get();
                int workerCount = workerCountOf(wc);
                if (workerCount >= CAPACITY || workerCount >= (core ? corePoolSize : maximumPoolSize)) {
                    return false;
                }
                if (comparaAndIncrementWorkerCount(wc)) {
                    break retry;
                }
                //如果当前线程池状态已被更改，需要重新判断状态及workerCount
                if (runStateOf(c) != rs) {
                    continue retry;
                }
            }
        }

        boolean workerStarted = false;
        boolean workerAdded = false;
        MyWorker w;
        try {
            w = new MyWorker(firstTask);
            final Thread t = w.thread;
            if (t != null) {
                final ReentrantLock mainLock = this.mainLock;
                mainLock.lock();
                try {
                    //TODO 判断线程状态
                    workers.add(w);
                    int size = workers.size();
                    if (size > largetPoolSize) {
                        largetPoolSize = size;
                    }
                    workerAdded = true;
                } finally {
                    mainLock.unlock();
                }
                if (workerAdded) {
                    t.start();
                    workerStarted = true;
                }
            }
        } finally {
            if (!workerStarted) {
                //TODO 线程启动失败处理
            }
        }

        return workerStarted;
    }

    private boolean comparaAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    final void runWorker(MyWorker worker) {
        Runnable task = worker.firstTask;
        worker.firstTask = null;
        worker.unlock();
        try {
            while (task != null) {
                worker.lock();
                try {
                    try {
                        task.run();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Error e) {
                        throw e;
                    } catch (Throwable e) {
                        throw e;
                    } finally {
                        //TODO afterExecute
                    }

                } finally {
                    task = null;
                    worker.completeTasks++;
                    worker.unlock();
                }
            }
        } finally {
            //TODO processWorkerExit
        }

    }

    private final class MyWorker
            extends AbstractQueuedSynchronizer
            implements Runnable {

        final Thread thread;

        Runnable firstTask;

        volatile long completeTasks;

        public MyWorker(Runnable firstTask) {
            //抑制中断直到runWorker
            setState(-1);
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }

        @Override
        public void run() {
            runWorker(this);
        }

        /**
         * 覆盖父类中的方法
         * @param unused
         * @return
         */
        @Override
        protected boolean tryAcquire(int unused) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 覆盖父类中的方法
         * @param unused
         * @return
         */
        @Override
        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public void lock() {
            acquire(1);
        }

        public void unlock() {
            release(1);
        }

    }
}
