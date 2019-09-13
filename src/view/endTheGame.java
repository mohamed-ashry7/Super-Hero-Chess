package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class endTheGame extends JPanel {

	
	JButton again ; 
	JLabel winner  ; 
	
	
	public endTheGame() { 
		this.setLayout(null);
		again = new JButton("Rematch , if You are a man ") ; 
		again.setFont(new Font("Serif",Font.BOLD,40));
		winner = new JLabel () ;
		again.setBounds(0,0,2000,100);
		winner.setFont(new Font ("Serif" , Font.BOLD,40));
		winner.setForeground(Color.WHITE);
		winner.setBounds(50,110,700,500);
		JLabel backg = new JLabel() ;
		backg.setBounds(0,100,2000,1000);
		backg.setIcon(new ImageIcon(this.getClass().getResource("salah.jpg")));

		this.add(winner);
		this.add(again) ;
		this.add(backg) ; 
	}


	public JButton getAgain() {
		return again;
	}


	public void setAgain(JButton again) {
		this.again = again;
	}


	public JLabel getWinner() {
		return winner;
	}


	public void setWinner(String msg) {
		winner.setText(msg);

	}
	
	
	
}
