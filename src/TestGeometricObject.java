/**public class TestGeometricObject {
    public static void main(String[] args) {

        GeometricObject circle1 = new Circle(15, "red", true);
        GeometricObject circle2 = new Circle(10, "blue", false);
        GeometricObject biggestCircle = new Circle();

        print("The biggest circle is: ");
        biggestCircle = Circle.max(circle1, circle2);
        print(biggestCircle);

        GeometricObject rectangle1 = new Rectangle(4, 5, "green", true);
        GeometricObject rectangle2 = new Rectangle(4.2, 5, "pink", true);
        GeometricObject biggestRectangle = new Rectangle();

        print("\nThe biggest rectangle is: ");
        biggestRectangle = Rectangle.max(rectangle1, rectangle2);
        print(biggestRectangle);

        GeometricObject triangle1 = new Triangle("violet", false, 2, 3, 3);
        GeometricObject triangle2 = new Triangle("black", true, 10, 9, 10);
        GeometricObject biggestTriangle = new Triangle();

        print("\nThe biggest triangle is: ");
        biggestTriangle = Triangle.max(triangle1, triangle2);
        print(biggestTriangle);

        if (biggestCircle.compareTo(biggestRectangle) > biggestRectangle.compareTo(biggestTriangle)
                && biggestCircle.compareTo(biggestRectangle) > biggestRectangle.compareTo(biggestTriangle)) {
            System.out.println("\nThe biggest geometric object is: \n" + (biggestCircle.compareTo(biggestRectangle) == 1 ? biggestCircle : biggestRectangle));
        } else if (biggestCircle.compareTo(biggestTriangle) > biggestCircle.compareTo(biggestRectangle)
                && biggestCircle.compareTo(biggestTriangle) > biggestRectangle.compareTo(biggestTriangle)) {
            System.out.println("The biggest geometric object is: \n" + (biggestCircle.compareTo(biggestTriangle) == 1 ? biggestCircle : biggestTriangle));
        }	else
            System.out.println((biggestRectangle.compareTo(biggestTriangle) == 1 ? biggestRectangle : biggestTriangle));
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(GeometricObject obj) {
        System.out.println(obj);
    }
}
 */