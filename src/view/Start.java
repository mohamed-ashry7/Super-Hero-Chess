package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Start extends JPanel {
	JTextField player1 ; 
	JTextField player2 ;
	JLabel labelpl1 ; 
	public JTextField getPlayer1() {
		return player1;
	}
	public void setPlayer1(JTextField player1) {
		this.player1 = player1;
	}
	public JTextField getPlayer2() {
		return player2;
	}
	public void setPlayer2(JTextField player2) {
		this.player2 = player2;
	}
	public JLabel getLabelpl1() {
		return labelpl1;
	}
	public void setLabelpl1(JLabel labelpl1) {
		this.labelpl1 = labelpl1;
	}
	public JLabel getLabelpl2() {
		return labelpl2;
	}
	public void setLabelpl2(JLabel labelpl2) {
		this.labelpl2 = labelpl2;
	}
	public JButton getPlay() {
		return play;
	}
	public void setPlay(JButton play) {
		this.play = play;
	}
	JLabel labelpl2 ;
	JButton play ; 
	public Start () { 
//		this.setLayout(null);
//		JLabel backg = new JLabel() ;
//		backg.setSize(new Dimension(2000,1124)); 
//		backg.setIcon(new ImageIcon(this.getClass().getResource("start1.png")));
////		JLabel ss = new JLabel() ;
////		ss.setBounds(150,150,200,300); 
////		ss.setIcon(new ImageIcon(this.getClass().getResource("123.gif")));
//		player1 = new JTextField("Player 1 ") ; 
//		player2 = new JTextField("Player 2 ") ; 
//		player1.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,30));
//		player2.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,30));
//
//		labelpl1 = new JLabel ("Player 1  : ") ;
//		labelpl1.setFont(new Font("Serif",Font.BOLD,30));
//		
//		labelpl1.setForeground(Color.yellow);
//		labelpl2 = new JLabel("Player 2 : ") ;
//		labelpl2.setFont(new Font("Serif",Font.BOLD,30));
//
//		Color r = new Color(136, 70, 72) ; 
//		labelpl2.setForeground(r);
//		play = new JButton("Choose Your Team ") ;
//		play.setContentAreaFilled(false);
//		player1.setBounds(150,500,150,50);
//		player2.setBounds(1500, 500, 150, 50);
//		labelpl1.setBounds(150,400,150,50);
//		labelpl2.setBounds(1500,400,150,50);
//		play.setBounds(700,500,400,400);
//		play.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("play1.png"))).getImage()
//				.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));		
//		play.setRolloverIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("play2.png"))).getImage()
//				.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
////		play.setFont(new Font("Serif",Font.BOLD,30));
////		play.setForeground(Color.WHITE);
//		this.add(player1);
//		this.add(player2);
//		this.add(labelpl1);
//		this.add(labelpl2);
//		this.add(play);
//		this.add(backg);
//		

		this.setLayout(null);
		JLabel backg = new JLabel() ;
		backg.setSize(new Dimension(2000,1124)); 
		backg.setIcon(new ImageIcon(this.getClass().getResource("start1.png")));
//		JLabel ss = new JLabel() ;
//		ss.setBounds(150,150,200,300); 
//		ss.setIcon(new ImageIcon(this.getClass().getResource("123.gif")));
		player1 = new JTextField("Player 1 ") ; 
		player2 = new JTextField("Player 2 ") ; 
		player1.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,30));
		player2.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,30));

		labelpl1 = new JLabel ("Player 1  : ") ;
		labelpl1.setFont(new Font("Serif",Font.BOLD,30));
		
		labelpl1.setForeground(Color.yellow);
		labelpl2 = new JLabel("Player 2 : ") ;
		labelpl2.setFont(new Font("Serif",Font.BOLD,30));

		Color r = new Color(136, 70, 72) ; 
		labelpl2.setForeground(r);
		play = new JButton("Choose Your Team ") ;
		play.setContentAreaFilled(false);
		player1.setBounds(850,250,150,50);
		player2.setBounds(850, 400, 150, 50);
		labelpl1.setBounds(700,250,150,50);
		labelpl2.setBounds(700,400,150,50);
		play.setBounds(700,600,400,100);
		play.setFont(new Font("Serif",Font.BOLD,30));
		play.setForeground(Color.WHITE);
		this.add(player1);
		this.add(player2);
		this.add(labelpl1);
		this.add(labelpl2);
		this.add(play);
//		this.add(ss) ; 
		this.add(backg);
		
		
		
	}

	
}
