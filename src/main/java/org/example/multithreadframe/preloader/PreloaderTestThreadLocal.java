package org.example.multithreadframe.preloader;

import org.example.multithreadframe.exec.PreLoadFunction;
import org.example.multithreadframe.exec.ServiceContext;
import org.example.multithreadframe.model.ImmutableProductInfo;
import org.example.multithreadframe.model.ProductInfo;
import org.example.multithreadframe.threadlocal.FptiTracingThreadLocal;

public class PreloaderTestThreadLocal<String> implements PreLoadFunction<String, ProductInfo> {

    @Override
    public Class<ProductInfo> getReturnType() {
        return ProductInfo.class;
    }

    @Override
    public ProductInfo preLoadData(ServiceContext<String> t) {
        System.out.println(Thread.currentThread().getName() + ":" + FptiTracingThreadLocal.get());
        return ImmutableProductInfo.builder().name("").price(1.1).build();
    }
}
