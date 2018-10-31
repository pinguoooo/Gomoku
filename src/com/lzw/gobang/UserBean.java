package com.lzw.gobang;

import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Time;

/**
 * @author Administrator
 */
public class UserBean implements Serializable {
    private boolean isActive;
    protected String name = "游客";
    protected InetAddress host;
    private Time time;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }
}
