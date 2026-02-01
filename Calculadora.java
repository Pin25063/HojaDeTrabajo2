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
                // Si es operador
                double b = stack.pop();
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
                    stack.push(a / b);
                    break;
                }
            }
        }
        return stack.peek();
    }
}
