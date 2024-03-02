package org.example.multithreadframe.exec;

import org.immutables.value.Value;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Value.Immutable
public interface Executor<T, R> {
    // 线程池
    ExecutorService exec = Executors.newFixedThreadPool(10);
    // 预加载器，可以并发执行
    List<PreLoadFunction<T, ?>> preloaders();
    // 处理器
    Processor<T, R> processor();

    // 执行器细节
    default R execute(final ServiceContext<T> serviceContext) {
        //
        final List<PreloadContextWrapper<?>> mapperContexts = preloaders().stream()
                .map(preloader -> execPreloader(serviceContext, preloader))
                .collect(Collectors.toList());

        PreDataStore preDataStore = new PreDataStore();
        for(PreloadContextWrapper preloadContextWrapper : mapperContexts) {
            preDataStore.getMap().put(preloadContextWrapper.getReturnType(), preloadContextWrapper.getResult());
        }

        R result = processor().apply(serviceContext, preDataStore);

        return result;
    }

    /**
     * 异步执行预加载器，返回PreloadContext的包装类型
     *
     * @param input 输入数据
     * @param preFunc 预加载器的实现类
     * @return PreloadContext的包装类型
     * @param <T> input 类型
     * @param <R> output 类型
     */
    static <T, R> PreloadContextWrapper<R> execPreloader(ServiceContext<T> input,
                                                         PreLoadFunction<T, R> preFunc) {
        return ImmutablePreloadContextWrapper.<R>builder().returnType(preFunc.getReturnType())
                .future(exec.submit(() -> preFunc.apply(input))).build();
    }
}
