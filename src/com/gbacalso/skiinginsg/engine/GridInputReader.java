/**
 * 
 */
package com.gbacalso.skiinginsg.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.gbacalso.skiinginsg.dataobject.Cell;
import com.gbacalso.skiinginsg.dataobject.Grid;

/**
 * @author gio
 *
 */
public class GridInputReader {
    private static final String FILE_NAME = "resources/map.txt";
    private static final String INPUT_DELIMITER = " ";

    /**
     * Gets the grid from input.
     *
     * @return the grid from input
     */
    public static Grid getGridFromInput() {
        List<List<Cell>> cellGrid = new ArrayList<List<Cell>>();
        Grid grid = new Grid();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_NAME)));
            String line;

            // first line of input file is for grid dimensions which will not be
            // needed for this implementation, so read and ignore it.
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                cellGrid.add(getCellListFromInputLine(line));
            }
            grid.setCellGrid(cellGrid);
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return grid;
    }

    private static List<Cell> getCellListFromInputLine(String inputLine) {
        List<Cell> cells = new ArrayList<Cell>();
        StringTokenizer tokenizer = new StringTokenizer(inputLine, INPUT_DELIMITER);
        while (tokenizer.hasMoreTokens()) {
            cells.add(new Cell(Integer.valueOf(tokenizer.nextToken())));
        }
        return cells;
    }
}
