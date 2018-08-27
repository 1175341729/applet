package com.xinchao.entrytask.api.common;

import com.google.common.annotations.VisibleForTesting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 任务编号生成
 */
public class GenerateNumber {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 任务编号
     * @return 编号字符串
     */
    public static synchronized String getTaskNum() {

        String num = simpleDateFormat.format(new Date());
        int i = (int) (Math.random() * 900) + 100;
        num = num.concat(String.valueOf(i));
        return num;
    }

    /**
     * 版本号
     * @return 版本号字符串
     */
    public static synchronized String getVersionNum(){
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");               //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return uuid;
    }

    public static void main(String[] args) {

        System.out.println(getTaskNum());
        System.out.println(getVersionNum());

    }
}
