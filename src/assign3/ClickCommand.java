/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign3;

/**
 *
 * @author Christian
 */
public class ClickCommand implements PaintCommand {
    
    public int row;
    public int col;
    public CellColor prevColor;
    public CellColor newColor;
    public GridModel model;
    
    public ClickCommand(int pRow, int pCol, CellColor pNewColor, GridModel pModel) {
        row = pRow;
        col = pCol;
        prevColor = pModel.getValue(row, col);
        newColor = pNewColor;
        model = pModel;
    }
    
    public void execute() {
        model.setValue(row, col, newColor);
    }
    
    public void undo() {
        model.setValue(row, col, prevColor);
    }
}
