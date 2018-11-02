package com.lzw.utils;

import com.lzw.gobang.UserBean;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Blockhead
 * 2018/10/31 18:47
 */
public class UserInfoUtils {
    private static Properties properties;

    /*
     * 加载配置文件
     */
    static {
        InputStream in = UserInfoUtils.class.getClassLoader().getResourceAsStream("user_info.properties");
        properties = new Properties();
        try {
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
        return properties.getProperty("username","大都督");
    }

    /**
     * 得到用户名
     * @return 本地的用户名
     */
    public static String getInetAddress(){
        return properties.getProperty("INetAddress",null);
    }

    /**
     * 保存用户名
     * @param name 用户名
     * @return 是否保存成功
     */
    public static boolean saveUsername(String name){
        properties.setProperty("username",name);
        return properties.getProperty("username").equals(name);
    }

    /**
     * 保存ip
     * @param ip 用户名
     * @return 是否保存成功
     */
    public static boolean saveINetAddress(String ip){
        properties.setProperty("INetAddress",ip);
        return properties.getProperty("INetAddress").equals(ip);
    }
}
