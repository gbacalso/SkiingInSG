/**
 * 
 */
package com.gbacalso.skiinginsg.dataobject;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Grid.
 *
 * @author gio
 */
public class Grid {
    private List<List<Cell>> cellGrid = new ArrayList<List<Cell>>();

    public void setCellGrid(List<List<Cell>> cellGrid) {
        this.cellGrid = cellGrid;
    }

    public Cell getCellAt(int x, int y) {
        if (y < cellGrid.size()) {
            if (x < cellGrid.get(y).size()) {
                return cellGrid.get(y).get(x);
            }
        }
        return new Cell();
    }

    public List<Cell> getRow(int y) {
        if (y < getRowCount()) {
            return cellGrid.get(y);
        }
        return new ArrayList<Cell>();
    }

    public int getColumnCountAtRow(int y) {
        return getRow(y).size();
    }

	public int getRowCount() {
        return cellGrid.size();
	}

}
