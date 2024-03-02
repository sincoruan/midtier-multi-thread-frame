package org.example.multithreadframe.exec;

import org.immutables.value.Value;

/**
 * 预加载器数据的封装类
 * @param <T>
 */
@Value.Immutable
public interface PreLoadContext<T> {
    T data();
}
