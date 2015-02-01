/**
 * 
 */
package com.gbacalso.skiinginsg.dataobject;

/**
 * @author gio
 *
 */
public class Cell {
    private boolean isActive = false;
    private int value = 0;

    public Cell() {
    }

    public Cell(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setValue(int value) {
        this.value = value;
        this.isActive = true;
    }
}
