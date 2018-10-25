package me.elvis.common.design.observer.another;

public class Employee implements Observer {

    private String name;
    private String msg;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void takeAction(String msg) {
        this.msg = msg;
        interview();
    }

    public void interview() {
        System.out.println(name + " received msg : " + msg + " and will go to interview");
    }

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
}
