package org.example.multithreadframe.exec;

import org.example.multithreadframe.exec.ImmutablePreLoadContext;

import java.util.function.Function;

/**
 * 预加载器接口
 * @param <T> input type
 * @param <R> return type
 */
public interface PreLoadFunction<T, R> extends Function<ServiceContext<T>, PreLoadContext<R>> {
    Class<R> getReturnType();

    R preLoadData(final ServiceContext<T> t);

    @Override
    default PreLoadContext<R> apply(final ServiceContext<T> serviceContext) {
        return ImmutablePreLoadContext.<R>builder().data(preLoadData(serviceContext)).build();
    }
}
