package org.example.multithreadframe.processor;

import org.example.multithreadframe.model.ImmutableProductDetail;
import org.example.multithreadframe.model.ProductDetail;
import org.example.multithreadframe.model.ProductInfo;
import org.example.multithreadframe.model.StoreInfo;
import org.example.multithreadframe.exec.PreDataStore;
import org.example.multithreadframe.exec.Processor;
import org.example.multithreadframe.exec.ServiceContext;

public class ProcessorProductDetail implements Processor<String, ProductDetail> {
    @Override
    public ProductDetail apply(ServiceContext<String> serviceContext, PreDataStore dataStore) {
        ProductInfo productInfo = (ProductInfo) dataStore.getMap().get(ProductInfo.class).data();
        StoreInfo storeInfo = (StoreInfo) dataStore.getMap().get(StoreInfo.class).data();

        return ImmutableProductDetail.builder()
                .name(productInfo.name())
                .count(storeInfo.count())
                .price(productInfo.price())
                .build();
    }
}
