import java.lang.Math;

public abstract class Shape3D extends Shape2D {
    abstract double getVolume();
}

class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public String getName() {
        return "cube";
    }

    public double getArea() {
        return 6 * (side * side);
    }

    public double getVolume() {
        return side * side * side;
    }
}

class Pyramid extends Shape3D {
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return "pyramid";
    }

    public double getArea() {
        return (length * width) + (length * Math.sqrt(((width / 2) * (width / 2)) + (height * height)) + (width * Math.sqrt(((length / 2) * (length / 2)) + (height * height))));
    }

    public double getVolume() {
        return (length * width * height) / 3.0;
    }
}

class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return "sphere";
    }

    public double getArea() {
        return 4 * Math.PI * (radius * radius);
    }

    public double getVolume() {
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }
}