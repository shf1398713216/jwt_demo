package com.example.jwtdemo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        FutureTask<String> tes1 = new FutureTask<>(() -> {
//            return "123";
//        });
//        FutureTask<String> tes2 = new FutureTask<>(() -> {
//            return "456";
//        });
//        FutureTask<String> tes3 = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "789";
//            }
//        }
//        );
//
//        Thread thread = new Thread(tes1);
//        Thread thread2 = new Thread(tes2);
//        thread.start();
//        thread2.start();
//
//        String s = tes1.get();
//        String s2 = tes2.get();
//        System.out.println(s);
//        System.out.println(s2);


        ArrayList<Object> objects = new ArrayList<>();

        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");

        Iterator<Object> iterator = objects.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            if ("2".equals(next)){
                iterator.remove();
            }
            System.out.println(next);

        }












    }

}
