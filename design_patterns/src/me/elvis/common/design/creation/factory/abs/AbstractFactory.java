package me.elvis.common.design.creation.factory.abs;

import me.elvis.common.design.creation.factory.abs.interfaces.Color;
import me.elvis.common.design.creation.factory.abs.interfaces.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String colorType);
    abstract Shape getShape(String shapeType);

}
