import java.util.ArrayList;

public class PilaArrayList<T> {
    
    ArrayList<T> stack;

    public PilaArrayList() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.size() == 0){
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.size() == 0){
            return null;
        }
        return stack.get(stack.size() - 1);
    }
}