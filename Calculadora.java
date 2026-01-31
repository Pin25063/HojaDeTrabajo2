public class Calculadora implements Calc{

    public int Operate (String input){
        String[] expression = input.split(" ");
        Stack<Integer> stack = new PilaVector<>();

        for (int i = 0; i < expression.length; i++){
            String token = expression[i];
            try {
                // Si es número
                int number = Integer.parseInt(token);
                stack.push(number);
            } catch (NumberFormatException e) {
                // Si es operador
                int b = stack.pop();
                int a = stack.pop();

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
