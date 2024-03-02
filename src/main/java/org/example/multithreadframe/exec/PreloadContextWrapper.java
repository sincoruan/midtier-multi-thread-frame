package org.example.multithreadframe.exec;

import org.immutables.value.Value;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 对PreLoadContext进行了封装
 * 作用：
 *   1.便于获取泛型化的PreLoadContext的真实数据类型
 *   2.future包装结果，便于异步执行
 * @param <T>
 */
@Value.Immutable
public interface PreloadContextWrapper<T> {
    // preloader执行结果的type
    Class<T> getReturnType();

    // future包装PreLoadContext，以便异步执行
    Future<PreLoadContext<T>> future();

    // block future, 拿到结果
    default PreLoadContext<T> getResult() {
        try{
            return future().get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
