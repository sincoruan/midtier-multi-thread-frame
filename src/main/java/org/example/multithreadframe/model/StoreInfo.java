package org.example.multithreadframe.model;

import org.immutables.value.Value;

@Value.Immutable
public interface StoreInfo {
    String name();
    Integer count();
}
