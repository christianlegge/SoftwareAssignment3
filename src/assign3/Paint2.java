/**
 * Here we re-factor Paint1 to isolate the model as a separate 
 * class---GridModel.  Also we factor out PaintPanel and call it
 * GridPanel and place it in a separate top-level class.
 * 
 * @author Andrew Vardy
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Paint2 extends MouseAdapter implements ActionListener {

	GridModel model = new GridModel(100, 100);
	JFrame frame = new JFrame("Paint2");
	GridPanel gridPanel = new GridPanel(400, 400, model);
	JButton clearButton = new JButton("Clear");
	
	public Paint2() {
		// Initialize frame and add the paintPanel in the center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(gridPanel);		
		
		// Create a panel on the left for buttons and add
		// the button to it
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));		
		buttonPanel.add(clearButton);
		frame.add(buttonPanel, BorderLayout.WEST);
		
		// Setup event listeners.  In this case, Paint2 is the
		// listener for all component events.
		clearButton.addActionListener(this);
		gridPanel.addMouseListener(this);
		gridPanel.addMouseMotionListener(this);
		
		frame.pack();
		frame.setResizable(false); // Must not be resizable because we aren't
		frame.setVisible(true);	   // handling changes in size.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.clearAll();
		gridPanel.repaint();
	}
	
	public void mousePressed(MouseEvent e) {
		int cellX = e.getX() / gridPanel.getCellWidth();
		int cellY = e.getY() / gridPanel.getCellHeight();
		
		if (cellX >= 0 && cellX < model.getWidth() && 
			cellY >= 0 && cellY < model.getHeight()) {
			model.setValue(cellX, cellY, true);
			gridPanel.repaint();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		mousePressed(e);
	}
	
	public static void main(String[] args) throws Exception {		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint2();
			}
		});
	}
}

