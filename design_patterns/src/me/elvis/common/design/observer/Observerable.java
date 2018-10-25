package me.elvis.common.design.observer;

public interface Observerable {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();

}
