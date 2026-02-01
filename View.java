import java.util.Scanner;

public class View {
    
    public Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.print(message);
    }
}
