package com.satyendra.lld.factory;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFactory {

    private static transient ShapeFactory shapeFactory;
    private ShapeFactory() {}

    static Map<ShapeType, Shape> map = new HashMap<>();
    static {
        map.put(ShapeType.CIRCLE, new Circle());
        map.put(ShapeType.SQUARE, new Square());
        map.put(ShapeType.RECTANGLE, new Rectangle());
    }
    public static Shape getShape(ShapeType shapeType) {
        return map.get(shapeType);
//        switch (shapeType.name()) {
//            case "CIRCLE":
//                return new Circle();
//            case "SQUARE":
//                return new Square();
//            case "RECTANGLE":
//                return new Rectangle();
//            default:
//                return null;
//        }
    }

    public static ShapeFactory getInstance() {
        if(shapeFactory == null) {
            shapeFactory = new ShapeFactory();
        }
        return shapeFactory;
    }
}
