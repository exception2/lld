package com.satyendra.lld.factory;

public class FactoryClient {

    public static void main(String[] args) {
        //ShapeFactory shapeFactory = ShapeFactory.getInstance();
        Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();
        Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
        square.draw();
        Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
        rectangle.draw();
    }
}
