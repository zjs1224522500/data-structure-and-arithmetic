package me.elvis.common.design.observer.another;

public class Hire {

    public static void main(String[] args) {
        Company sap = new Company();
        Observer elvis = new Employee("elvis");
        Observer james = new Employee("james");
        Observer ervin = new Employee("ervin");
        sap.registerObserver(elvis);
        sap.registerObserver(james);
        sap.registerObserver(ervin);

        sap.announcenMsg("Only 2 hc left!!!");
        sap.removeObserver(james);
        sap.announcenMsg("Only 1 hc left!!!");

    }
}
