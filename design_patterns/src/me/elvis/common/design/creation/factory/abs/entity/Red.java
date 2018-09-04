package me.elvis.common.design.creation.factory.abs.entity;

import me.elvis.common.design.creation.factory.abs.interfaces.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Red : fill ");
    }
}

