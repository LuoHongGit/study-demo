package cn.lh.travel.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String getUUID(){
         return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getUUIDWithLength(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();

    }
    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + UUID.randomUUID().toString());
        System.out.println("格式化后的UUID ：" + getUUIDWithLength(10));
    }
}