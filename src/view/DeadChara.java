package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.pieces.Piece;

public class DeadChara extends JPanel {
	


	public void setDead(ArrayList<JButton> dead) {
		
			this.setPreferredSize(new Dimension(500, 500));
			this.setLayout(new GridLayout(3, 3));
			this.setVisible(true );
			this.removeAll();
			this.repaint();
			this.revalidate();
			
		    for (int i = 0; i < dead.size(); i++){
		    	this.add(dead.get(i));
		    }
		
			
		}
	

	public DeadChara() { 
		this.setLayout(new GridLayout(3, 3));
		this.setOpaque(false);
		
	}
	
	
}
