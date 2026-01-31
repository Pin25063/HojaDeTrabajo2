import java.util.Vector;

public class PilaVector<T> implements Stack<T> { 
    Vector<T> stack; 

    public PilaVector(){
        this.stack = new Vector<>();
    }

    public void push(T item) { 
        stack.add(item);
    }

    public T pop() { 
        if (stack.isEmpty()) return null; 
        return stack.remove(stack.size() - 1);
    }

    public T peek() { 
        if (stack.isEmpty()) return null; 
        return stack.lastElement();
    }    
}