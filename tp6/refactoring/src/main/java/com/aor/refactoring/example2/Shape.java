package com.aor.refactoring.example2;

public abstract class Shape {

    private final double x;
    private final double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void draw(GraphicFramework graphics);

    protected double getX() {
        return this.x;
    }

    protected double getY() {
        return this.y;
    }
}
