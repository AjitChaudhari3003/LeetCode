// 3484. Design Spreadsheet
// A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 105.
// Implement the Spreadsheet class:
// Spreadsheet(int rows) Initializes a spreadsheet with 26 columns (labeled 'A' to 'Z') and the specified number of rows. All cells are initially set to 0.
// void setCell(String cell, int value) Sets the value of the specified cell. The cell reference is provided in the format "AX" (e.g., "A1", "B10"), where the letter represents the column (from 'A' to 'Z') and the number represents a 1-indexed row.
// void resetCell(String cell) Resets the specified cell to 0.
// int getValue(String formula) Evaluates a formula of the form "=X+Y", where X and Y are either cell references or non-negative integers, and returns the computed sum.
// Note: If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.
// Example 1:
// Input:
// ["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
// [[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]
// Output:
// [null, 12, null, 16, null, 25, null, 15]

import java.util.*;

class Spreadsheet {
    private int rows;
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        return get(parts[0]) + get(parts[1]);
    }

    private int get(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return cells.getOrDefault(s, 0);
        }
    }
}
