public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        return obj1.compareTo(obj2) == 1 ? obj1 : obj2;
    }

    public int compareTo(GeometricObject obj) {
        if (this.getArea() > obj.getArea())
            return 1;
        else if (this.getArea() < obj.getArea())
            return -1;
        else
            return 0;
    }

    public abstract boolean equals(Object obj);

    public String toString() {
        return "created on " + dateCreated + "\nColor: " + color +
                "\nIs filled: " + filled;
    }
}