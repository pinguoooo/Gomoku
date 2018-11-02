package com.lzw.utils;

import com.lzw.gobang.UserBean;

import java.io.*;
import java.util.Properties;

/**
 * @author Blockhead
 * 2018/10/31 18:47
 */
public class UserInfoUtils {
    private static Properties properties;
    private static InputStreamReader in;
    private static FileOutputStream out;

    /*
     * 加载配置文件
     */
    static {
        try {
            InputStreamReader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("src/user_info.properties"))),"utf-8");
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            //不用向上抛出
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到用户名
     * @return 本地的用户名
     */
    public static String getUserName(){
        return properties.getProperty("username");
    }


    /**
     * 保存用户名
     * @param name 用户名
     * @return 是否保存成功
     */
    public static boolean saveUsername(String name) throws IOException {
        out = new FileOutputStream(new File("src/user_info.properties"));
        properties.setProperty("username",name);
        properties.store(out,"保存用户名");
        closeResource();
        return properties.getProperty("username").equals(name);
    }

    /**
     * 得到ip
     * @return 本地的ip
     */
    public static String getInetAddress(){
        return properties.getProperty("INetAddress");
    }

    /**
     * 保存ip
     * @param ip 用户名
     * @return 是否保存成功
     */
    public static boolean saveINetAddress(String ip) throws IOException {
        out = new FileOutputStream(new File("src/user_info.properties"));
        properties.setProperty("INetAddress",ip);
        properties.store(out,"保存ip");
        closeResource();
        return properties.getProperty("INetAddress").equals(ip);
    }

    private static void closeResource(){
        if (in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out !=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
