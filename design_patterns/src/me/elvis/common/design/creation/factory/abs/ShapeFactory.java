package me.elvis.common.design.creation.factory.abs;

import me.elvis.common.design.creation.factory.abs.entity.Circle;
import me.elvis.common.design.creation.factory.abs.entity.Rectangle;
import me.elvis.common.design.creation.factory.abs.interfaces.Color;
import me.elvis.common.design.creation.factory.abs.interfaces.Shape;

public class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String colorType) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }

}
