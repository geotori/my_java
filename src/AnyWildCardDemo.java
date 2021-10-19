public class AnyWildCardDemo {
    public static void main(String[] args ) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1); // 1 is autoboxed into new Integer(1)
        intStack.push(2);
        intStack.push(-2);

            print(intStack);
        }

        public static void print(GenericStack<?> stack) {
            while (!stack.isEmpty()) {
                System.out.println(stack.pop() + " ");
        }
    }
}
