/**
 * 
 */
package com.gbacalso.skiinginsg.engine;

import com.gbacalso.skiinginsg.controllers.GridNavigator;
import com.gbacalso.skiinginsg.dataobject.Cell;
import com.gbacalso.skiinginsg.dataobject.Grid;
import com.gbacalso.skiinginsg.dataobject.Path;

/**
 * The Class BestSlopePathFinder.
 *
 * @author gio
 */
public class BestSlopePathFinder {
    private Grid grid = new Grid();

    public BestSlopePathFinder(Grid grid) {
        super();
        this.grid = grid;
    }

    public Path findBestPath() {
        Path bestPath = new Path();

        for (int y = 0; y < grid.getRowCount(); y++) {
            for (int x = 0; x < grid.getColumnCountAtRow(y); x++) {
                GridNavigator gridNavigator = new GridNavigator(grid);
                gridNavigator.setxPosition(x);
                gridNavigator.setyPosition(y);

                if (gridNavigator.getCellAtCurrentPosition().isActive()) {
                    bestPath = getBetterPath(bestPath, navigatePotentialBestPath(new Path(), gridNavigator));
                }
            }
        }
        return bestPath;
    }

    private Path navigatePotentialBestPath(Path bestPathSoFar, GridNavigator currentPosition) {
        Path tempSubPath = new Path();
        tempSubPath.appendPath(bestPathSoFar);
        tempSubPath.appendCell(currentPosition.getCellAtCurrentPosition());

        currentPosition.getCellAtCurrentPosition().setActive(false);

        Path bestPath = getBetterPath(bestPathSoFar, navigateDown(tempSubPath, currentPosition));

        bestPath = getBetterPath(bestPath, navigateRight(tempSubPath, currentPosition));

        bestPath = getBetterPath(bestPath, navigateUp(tempSubPath, currentPosition));

        bestPath = getBetterPath(bestPath, navigateLeft(tempSubPath, currentPosition));

        return bestPath;
    }

    private Path navigateDown(Path bestPathSoFar, GridNavigator currentPosition) {
        GridNavigator gridNavigator = new GridNavigator(currentPosition);
        if (gridNavigator.moveDown() == true) {
            bestPathSoFar = navigatePotentialBestPath(bestPathSoFar, gridNavigator);
        }

        return bestPathSoFar;

    }

    private Path navigateUp(Path bestPathSoFar, GridNavigator currentPosition) {

        GridNavigator gridNavigator = new GridNavigator(currentPosition);
        if (gridNavigator.moveUp() == true) {
            bestPathSoFar = navigatePotentialBestPath(bestPathSoFar, gridNavigator);
        }

        return bestPathSoFar;

    }

    private Path navigateLeft(Path bestPathSoFar, GridNavigator currentPosition) {

        GridNavigator gridNavigator = new GridNavigator(currentPosition);
        if (gridNavigator.moveLeft() == true) {
            bestPathSoFar = navigatePotentialBestPath(bestPathSoFar, gridNavigator);
        }

        return bestPathSoFar;

    }

    private Path navigateRight(Path bestPathSoFar, GridNavigator currentPosition) {

        GridNavigator gridNavigator = new GridNavigator(currentPosition);
        if (gridNavigator.moveRight() == true) {
            bestPathSoFar = navigatePotentialBestPath(bestPathSoFar, gridNavigator);
        }

        return bestPathSoFar;

    }

    private Path getBetterPath(Path pathA, Path pathB) {
        if (pathA.getPathLength() < pathB.getPathLength()) {
            return pathB;
        }

        if (pathA.getPathLength() == pathB.getPathLength() && pathA.getDrop() < pathB.getDrop()) {
            return pathB;
        }

        return pathA;
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid = GridInputReader.getGridFromInput();

        BestSlopePathFinder slopFinder = new BestSlopePathFinder(grid);
        Path bestPath = slopFinder.findBestPath();

        System.out.println("best path length : " + bestPath.getPathLength());
        System.out.println("best path drop   : " + bestPath.getDrop());
        System.out.print("best path route  : ");
        for (Cell cell : bestPath.getCellSequence()) {
            System.out.print(cell.getValue() + " ");
        }
    }
}
