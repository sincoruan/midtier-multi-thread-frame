package org.example;

import org.example.multithreadframe.exec.ImmutableExecutor;
import org.example.multithreadframe.exec.ImmutableServiceContext;
import org.example.multithreadframe.model.ProductDetail;
import org.example.multithreadframe.preloader.PreloaderProduct;
import org.example.multithreadframe.preloader.PreloaderStore;
import org.example.multithreadframe.exec.Executor;
import org.example.multithreadframe.exec.ServiceContext;
import org.example.multithreadframe.processor.ProcessorProductDetail;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
