package com.wangsen.huoche;

public class Stations implements Runnable {

    //该站台有100张票
    private static int tickets =  100;

    private String name = "";

    public Stations(String name){
        this.name = name;
    }
    //定义锁
    private static String a = "ob";

    protected String getName(){
        return this.name;
    }

    @Override
    public void run() {
        while (tickets>0){
            synchronized (a){
                if(tickets>0){
                    tickets--;
                    System.out.println(getName()+"正在放票，当前还有票"+tickets+"张");
                }else {
                    System.out.println("票卖完了");
                }
            }
        }
    }

    public static void main(String[] args) {
        Platform platform1 = new Platform("窗口1");
        Platform platform2 = new Platform("窗口2");
        Platform platform3 = new Platform("窗口3");
        new Thread(platform1).start();
        new Thread(platform2).start();
        new Thread(platform3).start();
    }
}
