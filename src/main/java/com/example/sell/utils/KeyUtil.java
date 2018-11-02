package com.example.sell.utils;

import java.util.Random;

/**
 * @Author: maoyuyang
 * @Description: 生成随机id
 * @Date: 16:43 18/11/2
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间 + 随机数
     * synchronized 保证唯一性
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
