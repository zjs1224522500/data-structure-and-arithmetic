package me.elvis.common.design.observer;

public class User implements Observer {

    private String name;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void update(String msg) {
        this.msg = msg;
        read();
    }

    private void read() {
        System.out.println(getName() + " received msg: " + getMsg());
    }

    public User(String name) {
        this.name = name;
    }
}
