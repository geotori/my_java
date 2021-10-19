/**public class MultiChoice {
    public static void main(String[] args) {
        new Circle();
    }
}

public abstract class GeometricObject {
    protected GeometricObject() {
        System.out.print("A");
    }
    protected GeometricObject(String color, boolean filled) {
        System.out.print("B");
    }
}

public class Circle extends GeometricObject {
    public Circle() {
        this(1.0);
        System.out.print("C");
    }
    public Circle(double radius) {
         this(radius, "white", false);
         System.out.print("D");
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        System.out.print("E");
    }
}*/


/**interface A {
    }

class C {
}

class B extends D implements A {
}

class D extends C {
}

class Test {
    public static void main(String[] args) {
        B b = new B();
        if (b instanceof A)
            System.out.println("b is an instance of A");
        if (b instanceof C)
            System.out.println("b is an instance of C");
    }
} */


/**public class MultiChoice {
    public Object max(Object o1, Object o2) {
        if ((Comparable)o1.compareTo(o2) >= 0) {
            return o1;
        } else {
            return o2;
        }
    }
}*/


/**public class MultiChoice {
    public static void main(String[] args) {
        Fruit[] fruits = {new Fruit(2), new Fruit(3), new Fruit(1)};
        java.util.Arrays.sort(fruits);
    }
}
class Fruit {
    private double weight;
    public Fruit(double weight) {
        this.weight = weight;
    }
} */