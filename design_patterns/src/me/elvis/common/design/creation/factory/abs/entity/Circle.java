package me.elvis.common.design.creation.factory.abs.entity;

import me.elvis.common.design.creation.factory.abs.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle : draw ");
    }
}
