import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JUnitTests {

    Stack<Integer> stack;
    Calc calculadora;
    
    @Before
    public void setup(){
        stack = new PilaVector<>();
        calculadora = new Calculadora();
    }

    @Test
    public void isLastElementFive(){
        stack.push(4);
        stack.push(5);
        assertEquals(Integer.valueOf(5) , stack.peek());
    }

    @Test
    public void isDeletedElementNine(){
        stack.push(4);
        stack.push(5);
        stack.push(9);
        int x = stack.pop();
        assertEquals(9 , x);
    }

    @Test
    public void isFinalResultFifteen(){
        Integer result = calculadora.Operate("1 2 + 4 * 3 +");
        assertEquals(Integer.valueOf(15), result);
    }
}
