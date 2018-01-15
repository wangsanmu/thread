package com.wangsen.huoche;

/**
 * 站台
 */
public class Platform extends Thread{
    //该站台有100张票
    private static int tickets =  100;

    public Platform(String name){
        super(name);
    }

    //定义锁
    private static String a = "ob";

    @Override
    public void run(){
        while (tickets>0){
            synchronized (a){
                if(tickets>0){
                    tickets--;
                    System.out.println(getName()+"正在放票，当前还有票"+tickets+"张");
                }else {
                    System.out.println("票卖完了");
                }
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Platform platform1 = new Platform("窗口1");
        Platform platform2 = new Platform("窗口2");
        Platform platform3 = new Platform("窗口3");
        platform1.start();
        platform2.start();
        platform3.start();
    }

}
