
// Update this file with your own code.
package textExcel;
import java.util.Scanner;

public class TextExcel {

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();
        Scanner scanner = new Scanner(System.in);
        System.out.println(spreadsheet.getGridText());
        
        while (true) {
            String command = scanner.nextLine();

            if (command.toLowerCase().equals("quit")) {
                break; // Exit loop when "quit" command is entered
            }

            String output = spreadsheet.processCommand(command);
            if (output != null) {
                System.out.println(output);
            }
        }

        scanner.close(); // Close the Scanner object after usage
    }
}
