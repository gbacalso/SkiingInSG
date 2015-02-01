/**
 * 
 */
package com.gbacalso.skiinginsg.controllers;

import com.gbacalso.skiinginsg.dataobject.Cell;
import com.gbacalso.skiinginsg.dataobject.Grid;

/**
 * The Class GridNavigator.
 *
 * @author gio
 */
public class GridNavigator {

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /** The grid. */
    private Grid grid;

    private int xPosition = 0;
    private int yPosition = 0;

    /**
     * Instantiates a new grid navigator.
     *
     * @param grid
     *            the grid
     */
    public GridNavigator(Grid grid) {
        super();
        this.grid = grid;
    }

    public GridNavigator(GridNavigator gridNavigator) {
        super();
        this.grid = gridNavigator.grid;
        this.xPosition = gridNavigator.xPosition;
        this.yPosition = gridNavigator.yPosition;
    }

    public Cell getCellAtCurrentPosition() {

        return getCell(xPosition, yPosition);
    }

    private Cell getCell(int x, int y) {
        return grid.getCellAt(x, y);
    }

    public boolean moveLeft() {
        if (xPosition == 0) {
            return false;
        }

        if (getCellAtCurrentPosition().getValue() <= getCell(xPosition - 1, yPosition).getValue()) {
            return false;
        }

        xPosition--;
        return true;
    }

    public boolean moveRight() {
        if (xPosition >= grid.getColumnCountAtRow(yPosition) - 1) {
            return false;
        }

        if (getCellAtCurrentPosition().getValue() <= getCell(xPosition + 1, yPosition).getValue()) {
            return false;
        }

        xPosition++;
        return true;
    }

    public boolean moveUp() {
        if (yPosition == 0 || xPosition >= grid.getColumnCountAtRow(yPosition - 1)) {
            return false;
        }

        if (getCellAtCurrentPosition().getValue() <= getCell(xPosition, yPosition - 1).getValue()) {
            return false;
        }

        yPosition--;
        return true;
    }

    public boolean moveDown() {
        if (yPosition == grid.getRowCount() - 1 || xPosition >= grid.getColumnCountAtRow(yPosition + 1)) {
            return false;
        }

        if (getCellAtCurrentPosition().getValue() <= getCell(xPosition, yPosition + 1).getValue()) {
            return false;
        }

        yPosition++;
        return true;
    }
}
