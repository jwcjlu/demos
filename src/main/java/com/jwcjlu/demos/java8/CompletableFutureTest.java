package com.jwcjlu.demos.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop("apple:10:NONE"),
                new Shop("pair:8:SILVER"),
                new Shop("orange:7:GOLD"),
                new Shop("balana:12:DIAMOND"));
        Executor executor=Executors.newCachedThreadPool();
        shops.stream().map((shop)->CompletableFuture.supplyAsync(
                ()->{
                    return shop.getPrice();
                }
                ,executor)).map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)
                ));
    }
}
 class Shop{
    private String name;
    public Shop(String name){
        this.name=name;
    }
     public String getPrice()  {
         //查询商品的数据库，或链接其他外部服务获取折扣
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         return name;
     }
 }
 class Discount{
     public enum Code{
         NONE(0),
         SILVER(5),
         GOLD(10),
         PLATINUM(15),
         DIAMOND(20);

         private final int value;

         Code(int value){
             this.value = value;
         }
     }
     public static String applyDiscount(Quote quote){
         return quote.getShopName() + "price :" + Discount.apply(quote.getPrice() ,quote.getDiscountCode());
     }
     public static double apply(double price,Code code){
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         return price * (100 - code.value) / 100;
     }
 }
 class Quote{
     private final String shopName;
     private final double price;
     private final Discount.Code discountCode;

     public Quote(String shopName, double price, Discount.Code code) {
         this.shopName = shopName;
         this.price = price;
         this.discountCode = code;
     }

     public static Quote parse(String s) {
         String[] split = s.split(":");
         String shopName = split[0];
         double price = Double.parseDouble(split[1]);
         Discount.Code discountCode = Discount.Code.valueOf(split[2]);
         return new Quote(shopName, price, discountCode);
     }

     public String getShopName() {
         return shopName;
     }

     public double getPrice() {
         return price;
     }

     public Discount.Code getDiscountCode() {
         return discountCode;
     }

 }
