/**
 * Implementación de una calculadora para expreciones postfix

 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class Calculadora implements CALC{
    

    /**
     * Evalúa la expresión
     * 
     * Precondición:
     * - La cadena de entrada no debe ser nula
     * - Los operandos y operadores deben de estar separados por un espacio
     * 
     * Postcondición:
     * - Retorna el resultado de evaluar la operación
     * - La pila se vacía al finalizar cada operación 
     * 
     * @param input de cadena con la operación para evaluar
     * @return resultado de la operación 
     * @throws IllegalArgumentException si el operador es inválido o no hay suficientes operandos
     * @throws ArithmeticException si se intenta dividir entre cero
     */
    @Override
    public double Operate (String input){
        
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("La entrada no puede estar vacía");
        }
        
        Stack<Double> stack = new PilaVector<>();
        //PilaArrayList<Double> stack = new PilaArrayList<>();
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
