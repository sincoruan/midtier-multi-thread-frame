package org.example.multithreadframe.preloader;

import org.example.multithreadframe.model.ImmutableStoreInfo;
import org.example.multithreadframe.model.StoreInfo;
import org.example.multithreadframe.exec.PreLoadContext;
import org.example.multithreadframe.exec.PreLoadFunction;
import org.example.multithreadframe.exec.ServiceContext;

public class PreloaderStore implements PreLoadFunction<String, StoreInfo> {
    @Override
    public Class<StoreInfo> getReturnType() {
        return StoreInfo.class;
    }

    @Override
    public StoreInfo preLoadData(ServiceContext<String> t) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ImmutableStoreInfo.builder().name("A").count(10).build();
    }

    @Override
    public PreLoadContext<StoreInfo> apply(ServiceContext<String> serviceContext) {
        return PreLoadFunction.super.apply(serviceContext);
    }
}
