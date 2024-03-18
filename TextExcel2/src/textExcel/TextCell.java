package textExcel;

public class TextCell extends Cell {
    private String value;

    public TextCell(String val) {
        this.value = val;
    }

    public String abbreviatedCellText() {
        String copyString = value  + "";
        if (copyString.length() <= 10) {
            // If the value is less than 10 characters, add spaces to make it 10 characters long
            while (copyString.length() < 10) {
                copyString += " ";
            }
            return copyString;
        } else {
            // If the value is more than 10 characters, truncate it to 10 characters
            return copyString.substring(0, 10);
        }
    }

    public String fullCellText() {
       
        value = "\"" + value + "\"";

        // System.out.println("printing maan -" + value + "-printed");
        return value;
    }

    public double getDoubleValue() {
        return -1.0; // As TextCell doesn't represent a numeric value, returning -1.0
    }
}
