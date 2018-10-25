package me.elvis.common.design.observer;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable {

    private List<Observer> list;
    private String msg;

    public WechatServer() {
        this.list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        list.forEach(observer -> {
            observer.update(msg);
        });
    }

    public void setInformation(String s) {
        this.msg = s;
        System.out.println("WeChat Server update msg : " + s);
        notifyObserver();
    }
}
