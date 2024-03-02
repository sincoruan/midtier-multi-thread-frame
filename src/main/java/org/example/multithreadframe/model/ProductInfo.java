package org.example.multithreadframe.model;

import org.immutables.value.Value;

@Value.Immutable
public interface ProductInfo {
    String name();
    double price();
}
