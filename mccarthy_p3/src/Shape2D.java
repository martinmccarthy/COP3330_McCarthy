import java.lang.Math;

public abstract class Shape2D extends Shape {

}

class Square extends Shape2D {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public String getName() {
        return "square";
    }

    public double getArea()
    {
        return side * side;
    }
}

class Triangle extends Shape2D {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public String getName() {
        return "triangle";
    }

    public double getArea() {
        return (base * height) / 2.0;
    }
}

class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return "circle";
    }

    public double getArea() {
        return (radius * radius) * Math.PI;
    }
}