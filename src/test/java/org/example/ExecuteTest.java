package org.example;

import org.example.multithreadframe.exec.*;
import org.example.multithreadframe.exec.ImmutableExecutor;
import org.example.multithreadframe.exec.ImmutableServiceContext;
import org.example.multithreadframe.model.ProductDetail;
import org.example.multithreadframe.preloader.PreloaderProduct;
import org.example.multithreadframe.preloader.PreloaderStore;
import org.example.multithreadframe.preloader.PreloaderTestThreadLocal;
import org.example.multithreadframe.processor.ProcessorProductDetail;
import org.example.multithreadframe.threadlocal.FptiCallable;
import org.example.multithreadframe.threadlocal.FptiTracingThreadLocal;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ExecuteTest {

    @Test
    void test() {
        Executor<String, ProductDetail> executor
                = ImmutableExecutor.<String, ProductDetail>builder().preloaders(
                        Arrays.asList(new PreloaderProduct(), new PreloaderStore())
                ).processor(new ProcessorProductDetail())
                .build();
        ServiceContext<String> serviceContext = ImmutableServiceContext.<String>builder().data("A").build();
        long start = System.currentTimeMillis();
        ProductDetail productDetail = executor.execute(serviceContext);
        System.out.println(productDetail);
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    @Test
    void testThreadLocal() {
        FptiTracingThreadLocal.set(new HashMap<>());
        FptiTracingThreadLocal.get().put("1", "a");
        Executor<String, String> executor
                = ImmutableExecutor.<String, String>builder().preloaders(
                        Arrays.asList(new PreloaderTestThreadLocal<String>(){})
                ).processor((Processor) (serviceContext, dataStore) -> {
                    System.out.println(FptiTracingThreadLocal.get());
                    return null;
                })
                .build();
        executor.execute(ImmutableServiceContext.<String>builder().data("").build());
    }
}
