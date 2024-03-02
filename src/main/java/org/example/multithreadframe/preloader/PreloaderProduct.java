package org.example.multithreadframe.preloader;

import org.example.multithreadframe.model.ImmutableProductInfo;
import org.example.multithreadframe.model.ProductInfo;
import org.example.multithreadframe.exec.PreLoadFunction;
import org.example.multithreadframe.exec.ServiceContext;

public class PreloaderProduct implements PreLoadFunction<String, ProductInfo> {
    @Override
    public Class<ProductInfo> getReturnType() {
        return ProductInfo.class;
    }

    @Override
    public ProductInfo preLoadData(ServiceContext<String> t) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ImmutableProductInfo.builder().name("A").price(1.0).build();
    }
}
