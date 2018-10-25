package me.elvis.common.design.observer.another;


import java.util.ArrayList;
import java.util.List;

public class Company implements Observerable {

    private List<Observer> employees;
    private String announcement;

    public List<Observer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Observer> employees) {
        this.employees = employees;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Company() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.employees.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!this.employees.isEmpty()) {
            this.employees.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        employees.forEach(employee -> employee.takeAction(announcement));
    }

    public void announcenMsg(String msg) {
        this.setAnnouncement(msg);
        notifyObserver();
    }
}
