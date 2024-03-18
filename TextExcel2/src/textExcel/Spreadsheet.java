package textExcel;

// Update this file with your own code.

public class Spreadsheet extends Grid
{
	private Cell[][] cells; // 2D array to represent the spreadsheet cells
    public Spreadsheet() {
        // Initialize the spreadsheet with empty cells
        cells = new Cell[20][12];
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 12; col++) {
                cells[row][col] = new EmptyCell();
            }
        }
    }


	public String processCommand(String command) {
		// quit case is checked in TextExel, now check other cases




		// case for clear all cell - command ==  "clear"
		String lowCommand = command.toLowerCase();
		if(lowCommand.equals("clear")) {
			clearAllCells();
			return getGridText();
		}

		
		// case of diplay content check like B1, B4, A8 ... 
		String[] trimed = lowCommand.split(" ");
		if(trimed.length == 1) {
			SpreadsheetLocation tempLoc = new SpreadsheetLocation(lowCommand);
			return cells[tempLoc.getRow()][tempLoc.getCol()].fullCellText();
			// return "sssssss";A
		}


		// case of clearig specific cell
		if(trimed.length == 2 && trimed[0].equals("clear")) {
			SpreadsheetLocation tempLoc = new SpreadsheetLocation(trimed[1]);
			cells[tempLoc.getRow()][tempLoc.getCol()] = new EmptyCell();
			return getGridText();
		}


		// now consider cases <cell> = <value>

		// case of text input
		if(command.contains("\"")) {
			// here trimed[0] is <cell>, and we seperate the letter and row number using substring
			int col = getColumnNumberFromColumnLetter(trimed[0].substring(0,1));
			int row = Integer.parseInt(trimed[0].substring(1)) - 1; // dont forget to subtract 1, our matrix is 0 indexed
			
			// // check for "" 
			// if (command.equals("\"\"")) {
			// 	System.out.println("I am here ");
			// 	cells[row][col] = new TextCell("\"\"");
			// 	return getGridText();
			// }

			// Find the index of the opening and closing quotation marks
			int start = command.indexOf("\"");
			int end = command.lastIndexOf("\"");
			
			// Extract the substring between the quotation marks
			String value = command.substring(start + 1, end);

			

			
			cells[row][col] = new TextCell(value);
		
			

			return  getGridText();
		}

		// case of percent
		if(command.contains("%")) {
			System.out.println("works Percent Cell creation case");
			int length = trimed[2].length();
			String value = trimed[2].substring(0, length - 1);
			int col = getColumnNumberFromColumnLetter(trimed[0].substring(0,1));
			int row = Integer.parseInt(trimed[0].substring(1)) - 1;
			cells[row][col] = new PercentCell(value);

			return getGridText();
		}
		


		// case of decimal or integer input
		if(trimed.length == 3 ) {
			System.out.println("works decimal or integer case");
			String value = trimed[2];
			int col = getColumnNumberFromColumnLetter(trimed[0].substring(0,1));
			int row = Integer.parseInt(trimed[0].substring(1)) - 1;
			cells[row][col] = new ValueCell(value);
			return getGridText();
		}


		// Case for Formula
		if(command.contains("(") && command.contains(")")) {
			// Find the opening and closing parentheses indices
			int openingIndex = command.indexOf('(');
			int closingIndex = command.indexOf(')', openingIndex);
				   
			// Extract the expression along with the parentheses
			String expression = command.substring(openingIndex, closingIndex + 1);
			int col = getColumnNumberFromColumnLetter(trimed[0].substring(0,1));
			int row = Integer.parseInt(trimed[0].substring(1)) - 1;
			cells[row][col] = new FormulaCell(expression, cells);

			return getGridText();

		}


		return "";
	}












	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cells[loc.getRow()][loc.getCol()];
	}

	private void clearAllCells() {
        // Clear all cells in the spreadsheet
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 12; col++) {
                cells[row][col] = new EmptyCell();
            }
        }
    }

	public String getGridText() { 
		// Initialize the grid header 
		String gridText = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |\n"; 
		for (int row = 1; row <= 20; row++) { 
		 // Right-align the row numbers 
		 if (row < 10) { 
		  gridText += row + "  "; 
		 } else { 
		  gridText += row + " "; 
		 } 
		 for (int col = 0; col < 12; col++) { 
		  // Ensure each cell content is followed by a single | with spaces 
		  String cellText = cells[row - 1][col].abbreviatedCellText(); 
		  gridText += "|"; 
		  gridText += cellText; // Adjust cell content to be left-aligned within 10 spaces
		 } 
		 gridText += "|\n"; // End each row with a newline 
		} 
		return gridText; 
	   }

	
	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}

	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
}
