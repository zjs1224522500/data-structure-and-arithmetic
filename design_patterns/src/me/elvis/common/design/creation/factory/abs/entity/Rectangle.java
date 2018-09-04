package me.elvis.common.design.creation.factory.abs.entity;

import me.elvis.common.design.creation.factory.abs.interfaces.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle : draw ");
    }
}
