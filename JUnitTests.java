import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JUnitTests {

    Stack<Double> stack;
    CALC calculadora;
    
    @Before
    public void setup(){
        stack = new PilaVector<>();
        calculadora = new Calculadora(stack);
    }

    @Test
    public void isLastElementFive(){
        stack.push(4.0);
        stack.push(5.0);
        assertEquals(5 , stack.peek(), 0.0);
    }

    @Test
    public void isDeletedElementNine(){
        stack.push(4.0);
        stack.push(5.0);
        stack.push(9.0);
        double x = stack.pop();
        assertEquals(9 , x, 0.0);
    }

    @Test
    public void isFinalResultFifteen(){
        double result = calculadora.Operate("1 2 + 4 * 3 +");
        assertEquals(15, result, 0.0);
    }
}
