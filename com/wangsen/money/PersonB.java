package com.wangsen.money;

public class PersonB implements Runnable{

    private Bank bank;

    private String name;

    public PersonB(Bank bank, String name){
        this.bank = bank;
        this.name = name;
    }

    @Override
    public void run() {
        while (bank.money >= 2000){
            synchronized (this){
                bank.Counter(name,2000);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
