package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Board extends JPanel {
	JButton[][] grid ; 
	Color dark;
	Color light ;
	public JButton[][] getGrid() {
//		 for (int i = 0; i < 7; i++){
//			 for (int j = 0 ; j < 6 ; j ++ ){
//				 grid[i][j] = new JButton() ; 
////				 if ((i+j)%2 == 0) { 
////						grid[i][j].setBackground(light);
////					}
////					else {
////						grid[i][j].setBackground(dark);
////					}
////					grid[i][j].setContentAreaFilled(false );
//		        }
//		    }
		 return grid ; 
	}

	public void setGrid(JButton[][] grid) {
		this.grid = grid;
		this.setPreferredSize(new Dimension(900, 900));
		this.setLayout(new GridLayout(7, 6));
		this.setVisible(true );
		this.setOpaque(false);
		this.removeAll();
		this.repaint();
		this.revalidate();
		
	    for (int i = 0; i < 7; i++){
	        for (int j = 0; j < 6; j++){
	            grid[i][j].setBorder(new LineBorder(Color.BLACK));
	            grid[i][j].setOpaque(true);
	            
	            this.add(grid[i][j]);
	        }
	    }
	
		
	}

	public Board () { 
		
//		this.setPreferredSize(new Dimension(900, 900));
//		this.setLayout(new GridLayout(7, 6));
//		this.setVisible(true );
//		grid = new JButton[7][6];
//		
//		
//	    for (int i = 0; i < 7; i++){
//	        for (int j = 0; j < 6; j++){
//	            grid[i][j] = new JButton();
//	            grid[i][j].setBorder(new LineBorder(Color.BLACK));
//	            grid[i][j].setOpaque(true);
//	            this.add(grid[i][j]);
//	        }
//	    }
		light = Color.LIGHT_GRAY ;  
		dark =Color.DARK_GRAY ; 
		grid = new JButton[7][6] ; 
		 for (int i = 0; i < 7; i++){
			 for (int j = 0 ; j < 6 ; j ++ ){
				 grid[i][j] = new JButton() ; 
//				 if ((i+j)%2 == 0) { 
//						grid[i][j].setBackground(light);
//					}
//					else {
//						grid[i][j].setBackground(dark);
//					}
					grid[i][j].setContentAreaFilled(false );
		        }
		    }
		
	
	
	}
	
	
	
	
	

}
