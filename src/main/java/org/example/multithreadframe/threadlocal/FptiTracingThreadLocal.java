package org.example.multithreadframe.threadlocal;


import java.util.Map;

public class FptiTracingThreadLocal {
    static InheritableThreadLocal<Map<String, String>> mapThreadLocal = new InheritableThreadLocal<>();
    public static Map<String, String> get(){
        return mapThreadLocal.get();
    }
    public static void set(Map<String, String> map) {
        mapThreadLocal.set(map);
    }
    public static void remove() {
        mapThreadLocal.remove();
    }
}
