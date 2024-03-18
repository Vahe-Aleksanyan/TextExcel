package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation extends Location
{

    private int row;
    private int col;

    // here cellName will be like A4, we cut A and convert it into corresponding number, and cut one more time to get 4
    public SpreadsheetLocation(String cellName) {
        // Parse the cell name to extract row and column numbers

        String firstPartUpperCase = cellName.substring(0, 1).toLowerCase();
        String secondPart = cellName.substring(1);
        this.col = Spreadsheet.getColumnNumberFromColumnLetter(firstPartUpperCase);
        this.row = Integer.parseInt(secondPart) - 1; // Subtract 1 to convert from 1-based index to 0-based index
    }


    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return col;
    }

}
