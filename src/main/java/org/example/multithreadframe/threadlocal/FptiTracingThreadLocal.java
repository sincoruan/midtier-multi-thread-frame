package org.example.multithreadframe.threadlocal;


import java.util.Map;

public class FptiTracingThreadLocal {
    static ThreadLocal<Map<String, String>> mapThreadLocal = new ThreadLocal<>();
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
