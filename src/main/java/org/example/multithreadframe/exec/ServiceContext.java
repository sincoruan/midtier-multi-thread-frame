package org.example.multithreadframe.exec;

import org.immutables.value.Value;

@Value.Immutable
public interface ServiceContext<T> {
    T data();
}
