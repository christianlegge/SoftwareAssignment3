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
public class ClearCommand implements PaintCommand {
    
    private CellColor oldGrid[][];
    private GridModel model;
    
    public ClearCommand(GridModel pModel) {
        model = pModel;
        oldGrid = new CellColor[model.getWidth()][model.getHeight()];
        for (int i=0; i<model.getWidth(); i++)
            for (int j=0; j<model.getHeight(); j++)
                oldGrid[i][j] = model.getValue(i, j);
    }
    
    public void execute() {
        model.clearAll();
    }
    
    public void undo() {
        for (int i=0; i<model.getWidth(); i++)
            for (int j=0; j<model.getHeight(); j++)
                model.setValue(i, j, oldGrid[i][j]);
    }
}
