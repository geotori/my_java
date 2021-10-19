import java.util.*;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        //Create a hash set
        Set<String> set = new LinkedHashSet<>();

        //Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Fransisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);

        //Display the elements in the hash set
        //for (Object element: set)
          //  System.out.print(element.toLowerCase() + " ");
    }
}
