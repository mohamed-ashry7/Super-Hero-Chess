package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseTheTeam extends JPanel  {

	JButton sherif1 ; 
	JButton sherif2 ; 
	JButton mons1 ; 
	JButton mons2 ; 

	JButton ghoul1 ; 
	JButton ghoul2 ; 
	JLabel Player1 ; 
	JLabel Player2 ; 
	JButton letStart ; 
	
	public ChooseTheTeam (String p1 ,String p2 ) { 
		 this.setLayout(null);
		 sherif1 = new JButton() ; 
		 sherif2=  new JButton(); 
		 Player1 = new JLabel() ; 
		 JLabel backg = new JLabel() ;
		backg.setSize(new Dimension(2000,1050)); 
		backg.setIcon(new ImageIcon(this.getClass().getResource("Choose3.png")));
		 Player1.setFont(new Font("Serif",Font.BOLD,20));
		 Player1.setForeground(Color.BLACK);
		 Player2 = new JLabel() ; 
		 Player2.setFont(new Font("Serif",Font.BOLD,20));
		 Player2.setForeground(Color.BLACK);
		 sherif1 = new JButton() ; 
		 JLabel sherif11 = new JLabel() ; 
		 JLabel sherif22 = new JLabel() ; 

		 sherif11.setIcon(new ImageIcon(this.getClass().getResource("Ranged3.gif")));
		 sherif2=  new JButton(); 
		 sherif22.setIcon(new ImageIcon(this.getClass().getResource("Ranged3.gif")));
		 sherif1.add(sherif11) ; 
		 sherif2.add(sherif22) ; 

		 mons1 =  new JButton() ; 

		 mons1.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("SideKick1.png"))).getImage()
					.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		 mons2=  new JButton() ; 
		 mons2.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("SideKick1.png"))).getImage()
					.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));

		 ghoul1=  new JButton() ; 
		 ghoul1.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("Tech2.png"))).getImage()
					.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		 ghoul2 =  new JButton();
		 ghoul2.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("Tech2.png"))).getImage()
					.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		 Player1.setBounds(300,250,300,200);
		 mons1.setBounds(200,400,150,150);
		 ghoul1.setBounds(350,400,150,150);
		 sherif1.setBounds(500, 400, 150, 150);
		 Player2.setBounds(1300,250,300,200);
		 letStart = new JButton("Let's start the War ") ;
		 mons2.setBounds(1200,400,150,150);
		 ghoul2.setBounds(1350,400,150,150);
		 sherif2.setBounds(1500,400, 150, 150);
		 sherif1.setContentAreaFilled(false );
		 sherif2.setContentAreaFilled(false );
		 mons1.setContentAreaFilled(false );
		 mons2.setContentAreaFilled(false );
		 ghoul1.setContentAreaFilled(false );
		 ghoul2.setContentAreaFilled(false );
		 letStart.setBounds(700,600,500,100);
		 letStart.setFont(new Font("Serif",Font.BOLD,30));
		 letStart.setForeground(Color.WHITE);
		 letStart.setEnabled(false );
		 this.add(Player1) ;
		 this.add(Player2) ;
		 this.add(mons1);
		 this.add(mons2);
		 this.add(ghoul1);
		 this.add(ghoul2);
		 this.add(sherif2);
		 this.add(sherif1);
		 this.add(this.letStart);
		 this.add(backg) ;



	}

	public JButton getSherif1() {
		return sherif1;
	}

	public void setSherif1(JButton sherif1) {
		this.sherif1 = sherif1;
	}

	public JButton getSherif2() {
		return sherif2;
	}

	public void setSherif2(JButton sherif2) {
		this.sherif2 = sherif2;
	}

	public JButton getMons1() {
		return mons1;
	}

	public void setMons1(JButton mons1) {
		this.mons1 = mons1;
	}

	public JButton getMons2() {
		return mons2;
	}

	public void setMons2(JButton mons2) {
		this.mons2 = mons2;
	}

	public JButton getGhoul1() {
		return ghoul1;
	}

	public void setGhoul1(JButton ghoul1) {
		this.ghoul1 = ghoul1;
	}

	public JButton getGhoul2() {
		return ghoul2;
	}

	public void setGhoul2(JButton ghoul2) {
		this.ghoul2 = ghoul2;
	}

	public JLabel getPlayer1() {
		return Player1;
	}

	public void setPlayer1(JLabel player1) {
		Player1 = player1;
	}

	public JLabel getPlayer2() {
		return Player2;
	}

	public void setPlayer2(JLabel player2) {
		Player2 = player2;
	}

	public JButton getLetStart() {
		return letStart;
	}

	public void setLetStart(JButton letStart) {
		this.letStart = letStart;
	}
	

	
}
