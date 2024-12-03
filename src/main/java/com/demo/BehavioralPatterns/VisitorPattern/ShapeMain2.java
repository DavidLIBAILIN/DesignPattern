package com.demo.BehavioralPatterns.VisitorPattern;

interface Shape{
    void accept(Visitor visitor);
}

class Circle implements Shape {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

class DrawVisitor implements Visitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("Draw Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Draw Rectangle");
    }
}

class ResizeVisitor implements Visitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("Resize Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Resize Rectangle");
    }
}


public class ShapeMain2 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        Visitor drawVisitor = new DrawVisitor();
        Visitor resizeVisitor = new ResizeVisitor();

        circle.accept(drawVisitor);
        rectangle.accept(resizeVisitor);

        circle.accept(resizeVisitor);
        rectangle.accept(drawVisitor);
    }
}
