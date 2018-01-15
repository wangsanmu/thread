package com.wangsen.KDF;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个KFC内，服务员负责生产食物，消费者负责消费食物；当生产到一定数量可以休息一下，直到消费完食物，再马上生产，一直循环
 */
public class KFC {
    //食物种类
    String[] names = { "薯条", "烧板", "鸡翅", "可乐"};
    //生成最大值
    private static final int Max = 100;
    //存放食物
    List<Food> foods = new ArrayList<>();

    //生产食物
    public void prod(int index){
        synchronized (foods){
            //如果食物量大于20
            while (foods.size()>Max){
                System.out.println("食材够了");
                try {
                    String name = Thread.currentThread().getName();
                    foods.wait();
                    System.out.println("生产者"+name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //开始生产食物
            for(int i=0; i < index; i++){
                Food food = new Food(names[(int)Math.random()*4]);
                foods.add(food);
                System.out.println(Thread.currentThread().getName()+"生产了"+food.getName()+foods.size());
            }

            foods.notify(); //唤醒所有消费者和生产者
        }
    }


    //消费食物
    public  void consu(int index){
        synchronized (foods){
            while (foods.size()<index){
                System.out.println("食材不够了");
                try {
                    String name = Thread.currentThread().getName();
                    foods.wait();
                    System.out.println("消费者"+name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //狗消费
            for(int i=0;i<index;i++){
                Food food = foods.remove(foods.size()-1);
                System.out.println(Thread.currentThread().getName()+"消费了一个"+food.getName()+foods.size());
            }
            foods.notify();

        }
    }
}
