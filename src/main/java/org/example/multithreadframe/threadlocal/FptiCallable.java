package org.example.multithreadframe.threadlocal;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 这个类其实就是对callable包了一层壳
 *
 * @param <V>
 */
public class FptiCallable<V> implements Callable<V> {
    // ftpi实例变量，用于将父线程的threadlocal中fptiMap 传递给子线程
    private Map<String, String> fptiMap;
    // 被包装的callable
    private Callable<V> delegate;
    public FptiCallable(Callable<V> delegate){
        this.delegate = delegate;
        // 1.构造函数中从当前线程(父)获取fptimap
        this.fptiMap = FptiTracingThreadLocal.get();
    }
    @Override
    public V call() throws Exception {
        // 2.子线程执行前set到子线程中
        FptiTracingThreadLocal.set(fptiMap);
        return delegate.call();
    }
}
