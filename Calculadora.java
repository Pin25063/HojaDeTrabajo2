public class Calculadora implements CALC{
    
    private Stack<Double> stack;

    public Calculadora(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public double Operate (String input){
        String[] expression = input.split(" ");

        for (int i = 0; i < expression.length; i++){
            String token = expression[i];
            try {
                // Si es número
                double number = Double.parseDouble(token);
                stack.push(number);
            } catch (NumberFormatException e) {
                
                if (stack.peek() == null) {
                    throw new IllegalArgumentException("No hay operandos suficientes");
                }
                double b = stack.pop();
                
                if (stack.peek() == null) {
                    throw new IllegalArgumentException("No hay operandos suficientes");
                }
                double a = stack.pop();

                switch (token) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("División entre cero");
                    }
                    stack.push(a / b);
                    break;
                default:
                    throw new IllegalArgumentException("Operador inválido");
                }
            }
        }
        
        double result = stack.pop();
        if (stack.peek() != null) {
            throw new IllegalArgumentException("Operación inválida");
        }
        return result;
    }
}
