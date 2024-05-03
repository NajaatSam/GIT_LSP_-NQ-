
package org.howard.edu.lsp.oopfinal.question3;

// Shape.java
public interface Shape {
    void draw();
}

// Circle.java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Circle!!!");
    }
}

// Rectangle.java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Rectangle!!!");
    }
}

// ShapeFactory.java
public class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("Circle");
        circle.draw();

        Shape rectangle = ShapeFactory.createShape("Rectangle");
        rectangle.draw();
    }
}
