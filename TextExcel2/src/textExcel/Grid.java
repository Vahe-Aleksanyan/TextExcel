package textExcel;

//*******************************************************
//DO NOT MODIFY THIS FILE!!!
//*******************************************************

// Grid must be extended by your Spreadsheet class
public class Grid 
{
	// processes a user command, returns string to display, must be called in loop from main
	public String processCommand(String command) { return null; }
	
	public int getRows() { return 0; } // returns number of rows in grid
	public int getCols() { return 0; } // returns number of columns in grid
	
	public Cell getCell(Location loc) {return null; } // returns cell at loc
	public String getGridText() { return null; } // returns entire grid, formatted as text for display
}
