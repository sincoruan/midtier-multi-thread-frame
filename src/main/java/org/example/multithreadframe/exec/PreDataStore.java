package org.example.multithreadframe.exec;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于存放，预加载器的执行结果
 * key：为执行结果的类类型
 * value：为具体的执行结果
 */
public class PreDataStore {
    private final Map<Class<?>, PreLoadContext<?>> map = new HashMap<>();
    public Map<Class<?>, PreLoadContext<?>> getMap() {
        return map;
    }
}
