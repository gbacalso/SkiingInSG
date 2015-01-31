/**
 * 
 */
package com.gbacalso.skiinginsg.dataobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gio
 *
 */
public class Path {
    private List<Cell> cellSequence = new ArrayList<Cell>();
	
    public List<Cell> getCellSequence() {
		return cellSequence;
	}

    public int getDrop() {
		return drop;
    }

	private int drop = 0;
	
    public int getPathLength() {
        return cellSequence.size();
    }

	public void appendCell(Cell cell){
		this.cellSequence.add(cell);
		this.drop = this.cellSequence.get(0).getValue() - cell.getValue();
	}
	
	public void appendPath(Path path){
		this.cellSequence.addAll(path.getCellSequence());
	}
}
