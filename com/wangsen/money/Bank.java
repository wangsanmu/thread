package com.wangsen.money;

//两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
public class Bank {

    static int  money = 5000;

    //柜台取钱
    public void Counter(String name,int money){
        this.money-=money;
        System.out.println(name+" 在柜台取钱"+money+",还剩"+this.money);
    }

    //ATM取钱
    public void ATM(String name,int money){
        this.money-=money;
        System.out.println(name+" ATM取钱"+money+",还剩"+this.money);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA personA = new PersonA(bank,"a");
        PersonB personB = new PersonB(bank,"b");
        new Thread(personA).start();
        new Thread(personB).start();
    }

}
