package org.example.multithreadframe.model;

import org.immutables.value.Value;

@Value.Immutable
public interface ProductDetail {
    String name();
    double price();
    int count();
}
