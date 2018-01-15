package com.wangsen.KDF;

public class MainClass {
    public static void main(String[] args) {
        KFC kfc = new KFC();

        new Thread(new Waiter(kfc)).start();
        new Thread(new Waiter(kfc)).start();
        new Thread(new Waiter(kfc)).start();

        new Thread(new Customer(kfc)).start();
        new Thread(new Customer(kfc)).start();

    }
}
