package me.elvis.common.design.creation.factory.abs;

import me.elvis.common.design.creation.factory.abs.entity.Green;
import me.elvis.common.design.creation.factory.abs.entity.Red;
import me.elvis.common.design.creation.factory.abs.interfaces.Color;
import me.elvis.common.design.creation.factory.abs.interfaces.Shape;

public class ColorFactory extends AbstractFactory {


    @Override
    Color getColor(String colorType) {
        if(colorType == null){
            return null;
        }
        if(colorType.equalsIgnoreCase("RED")){
            return new Red();
        } else if(colorType.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        return null;
    }
}
