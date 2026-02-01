import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        Stack<Double> stack = new PilaVector<>();
        CALC calculadora = new Calculadora(stack);
        View vista = new View();

        try (
            FileReader FileReader = new FileReader("datos.txt");
            BufferedReader BufferReader = new BufferedReader(FileReader);
            ) {
                String line;
                while ((line = BufferReader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        try {
                            double result = calculadora.Operate(line);
                            vista.showMessage(line + " = " + result);

                        } catch (Exception e) {
                            vista.showMessage("Error: " + e.getMessage());
                        }
                    }
                }
        } catch (IOException e) {
            vista.showMessage("Error al leer el archivo datos.txt");
        }
    }
}