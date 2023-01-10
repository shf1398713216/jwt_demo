package com.example.jwtdemo.config;

//import org.jeecg.common.util.RedisUtil;
//import org.jeecg.common.util.SpringContextUtils;

/**
 * 单实例
 */
public class MyThreadLocal {


//    public static RedisUtil redisUtil = SpringContextUtils.getBean(RedisUtil.class);


    private MyThreadLocal() {
    }

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 对当前线程中的map域设置属性值，不会对其他线程产生影响  Thread.currentThread()
     *
     * @param obj
     */
    public static void set(String obj) {
        threadLocal.set(obj);
    }

    public static String get() {
        return  threadLocal.get();
    }

    /**
     * 本质上是调用当前线程的remove，不会对其他线程产生影响
     */
    public static void remove() {
        threadLocal.remove();
    }
}

