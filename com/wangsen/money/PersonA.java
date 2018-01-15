package com.wangsen.money;

public class PersonA implements Runnable{

    private Bank bank;

    private String name;

    public PersonA(Bank bank, String name){
        this.bank = bank;
        this.name = name;
    }

    @Override
    public void run() {
        while (bank.money >= 1000){
            synchronized (this){
                bank.ATM(name,1000);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
