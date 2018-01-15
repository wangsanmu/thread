package com.wangsen.KDF;

public class Waiter implements Runnable{
    private KFC kfc;

    public Waiter(KFC kfc){
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size =(int) (Math.random()*5)+5;
        while (true){
            kfc.prod(size);
        }
    }
}
