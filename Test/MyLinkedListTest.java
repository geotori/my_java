import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    private MyLinkedList<String> list;
    private String[] food = {"sushi", "apple", "pizza", "banana", "cake", "roast beef"};

    @BeforeEach
    public void setUp() {
        list = new MyLinkedList<>(food);
    }

    @Test
    public void contains_ElementInList_ReturnsTrue() {
        assertTrue(list.contains("sushi"));
    }

    @Test
    public void contains_ElementNotInList_ReturnsFalse() {
        assertFalse(list.contains("pear"));
    }

    @Test
    public void get_Index0_ReturnsFirstElement() {
        assertEquals(list.get(0), "sushi");
    }

    @Test
    public void get_LastIndex_ReturnsLastElement() {
        assertEquals(list.get(5), "roast beef");
    }

    @Test
    public void get_MiddleIndex_ReturnsElementInMiddle() {
        assertEquals(list.get(2), "pizza");
    }

    @Test
    public void get_InvalidIndex_ThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.get(-1);
        });
    }

    @Test
    public void indexOf_FirstElement_Returns0() {
        assertEquals(list.indexOf("sushi"), 0);
    }

    @Test
    public void indexOf_LastElement_ReturnsLastIndex() {
        assertEquals(list.indexOf("roast beef"), 5);
    }

    @Test
    public void indexOf_NonExistentElement_ReturnsMinus1() {
        assertEquals(list.indexOf("watermelon"), -1);
    }

    @Test
    public void lastIndexOf_OnlyOneElement_ReturnsElementsIndex() {
        assertEquals(list.lastIndexOf("sushi"), 0);
    }

    @Test
    public void lastIndexOf_MoreThanOneElements_ReturnsLastElementsIndex() {
        list.add("lasagne");
        assertEquals(list.lastIndexOf("lasagne"), 6);
    }

    @Test
    public void lastIndexOf_NonExistentElement_ReturnsMinus1() {
        assertEquals(list.lastIndexOf("watermelon"), -1);
    }
}
