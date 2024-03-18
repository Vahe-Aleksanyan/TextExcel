package textExcel;

public class EmptyCell extends Cell{
    @Override
    public String abbreviatedCellText() {
        return "          "; // 10 spaces for an empty cell
    }

    @Override
    public String fullCellText() {
        return ""; // Empty string for an empty cell
    }

    @Override
    public double getDoubleValue() {
        return -1; // Value 0.0 for an empty cell
    }
}