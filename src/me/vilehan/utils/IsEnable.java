package me.vilehan.utils;

public class IsEnable {

    public static boolean enable;
    public static boolean initEvent;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public boolean getEnable(){
        return enable;
    }
    public void setInitEvent(boolean initEvent) {
        this.initEvent= initEvent;
    }
    public boolean getInitEvent(){
        return initEvent;
    }
}
