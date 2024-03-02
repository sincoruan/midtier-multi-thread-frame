package org.example.multithreadframe.exec;

public interface Processor<T, R> {
    R apply(ServiceContext<T> serviceContext, PreDataStore dataStore);
}
