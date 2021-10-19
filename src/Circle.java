public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle (double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getArea() == ((Circle)obj).getArea();
    }

    @Override
    public String toString() {
        return super.toString() + "\nCircle \nRadius: " + radius + "\nArea: " + getArea()
                + "\nPerimeter: " + getPerimeter();
    }
}