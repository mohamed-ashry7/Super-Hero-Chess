package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import Run.PlayTheGame;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;
import view.GUI;

public class Control {

	private Game game;
	private GUI view;
	private Piece Current;
	private boolean move;
	private boolean usepower;
	private Direction dir;
	private Piece target;
	private boolean tele;
	private Color colCurrent;
	private Color colTarget;
	private JButton CurBut;
	private JButton TarBut;
	ArrayList<JButton> dead1;
	ArrayList<JButton> dead2;
	String Tech;
	String Super;
	String Medic;
	String Ranged;
	String SideKick;
	String Speedster;
	String Armored;
	String chara1;
	String chara2;
	boolean choose1;
	boolean choose2;
	String tech;
	String superr;
	String ranged;
	String speedster;
	String medic;
	String armored;
	String sidekick;
	JLabel CurLab ; 
	JLabel TarLab ; 
	Piece info ; 
	
	public Control(Game game, GUI view) {
		this.view = view;
		this.game = game;
		LetStart ss = new LetStart();
		ChooseTeam ct = new ChooseTeam();
		view.getChooseTheTeam().getSherif1().addActionListener(ct);
		view.getChooseTheTeam().getSherif2().addActionListener(ct);
		view.getChooseTheTeam().getGhoul1().addActionListener(ct);
		view.getChooseTheTeam().getGhoul2().addActionListener(ct);
		view.getChooseTheTeam().getMons1().addActionListener(ct);
		view.getChooseTheTeam().getMons2().addActionListener(ct);
		chara1 = "" ; 
		chara2 = "" ; 
		info = null ; 
		colCurrent = new Color(150, 70, 100);
		colTarget = new Color(70, 80, 240);
		setactionLisformoves();
		Move m = new Move();
		UsePower p = new UsePower();
		TechAbil T = new TechAbil();
		Rematch ko = new Rematch();
		ClearHandle cc = new ClearHandle();
		view.getChooseTheTeam().getLetStart().addActionListener(ss);
		view.getClear().addActionListener(cc);
		CurBut = new JButton();
		TarBut = new JButton();
		CurLab = new JLabel() ; 
		TarLab = new JLabel () ; 
		Tech = "<html>Hi, I am Tech. I can move one cell in any diagonal direction. I also can use one of the following, without ending the turn afterwards: 1. Teleporting a friendly piece into any"
				+ "empty cell on the board. 2. Hacking an enemy hero piece so that it cannot use its ability.EXCEPT THE SPEEDSTER. 3. Restoring the ability of another friendly piece, enabling it to be used again. Unlike all of my friends, I am the smartest";

		Super = "<html> Hi, I am Super. I can move one cell vertically or horizontally. I can also smash two "
				+ "adjacent cells vertically or horizontally, eliminating any enemy pieces within them. We are "
				+ "friends. Any help?  ";
		Ranged = "<html>Hi, I am Ranged. I can move one cell in all directions. I can also eliminate the "
				+ "first enemy piece that is encountered is the specified direction but only in a vertical or a"
				+ "horizontal direction. The distance of the enemy piece takes no difference, provided that the"
				+ "path is not blocked by one of my lovely friends ";

		Medic = "<html> Hi, I am Medic. I can move one cell vertically or horizontally. I can also resurrect"
				+ "a dead friend to the adjacent cell in all directions. The special ability of my dead friend is also"
				+ "restored. If you need a doctor contact me. ";
		Armored = "<html>Hi, I am Armored. I can move one cell in all directions. I can survive the first"
				+ "damage taken through any type of attack. Unlike all of my friends, I am the strongest.";
		Speedster = "<html>Hi, I am Speedster. I can traverses two cells instead of one in all directions in "
				+ "any movement throughout the entire battle. Unlike all of my friends, I am the fastest.";
		SideKick = "<html>Hi, I am Sidekick. I can move one cell in only towards the enemy field."
				+ "Whenever I eliminate a hero piece, I can transform into a new hero piece of the same type "
				+ "of the eliminated hero piece. Unlike all of my friends, I am the transformer.";
		view.getDirections().getMove().addActionListener(m);
		view.getUsePower().addActionListener(p);
		view.getHackRestore().addActionListener(T);
//		view.getRestore().addActionListener(T);
		view.getTeleport().addActionListener(T);
		view.getEnded().getAgain().addActionListener(ko);

	}

	public void setactionLisformoves() {
		HandleDirection e = new HandleDirection();
		view.getDirections().getMoveDown().addActionListener(e);
		view.getDirections().getMoveDownLeft().addActionListener(e);
		view.getDirections().getMoveDownRight().addActionListener(e);
		view.getDirections().getMoveRight().addActionListener(e);
		view.getDirections().getMoveLeft().addActionListener(e);
		view.getDirections().getMoveUp().addActionListener(e);
		view.getDirections().getMoveUpRight().addActionListener(e);
		view.getDirections().getMoveUpLeft().addActionListener(e);


	}

	public void Set() {
		JButton[][] Board = view.getBoard().getGrid();
		HandleButton b = new HandleButton();
		infoHandle f = new infoHandle();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				String cur = "";
				JLabel chara = new JLabel();
				 Board[i][j] = new JButton();

				if (game.getCellAt(i, j).getPiece() != null) {
					Piece p = game.getCellAt(i, j).getPiece();
					if ((i+j)%2 == 0) { 
						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell1.png"))).getImage()
								.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
					}
					else {
						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell2.png"))).getImage()
								.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));			
						}
					Board[i][j].setContentAreaFilled(false );

					if (p instanceof SideKick) {
						 Board[i][j].setText(p.getName());
						if (p.getOwner().equals(game.getPlayer1())) {
							cur = "SideKick" + chara1;
						} else {
							cur = "SideKick" + chara2;
						}						

						sidekick = p.getName() + " (Sidekick)  " + p.getOwner().getName();
						Board[i][j].setToolTipText(sidekick);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));		
						Board[i][j].add(chara);

					}

					else if (p instanceof Armored) {
						 Board[i][j].setText(p.getName());
						String shield = "down";

						if (((Armored) p).isArmorUp()) {
							shield = "up";
							if (p.getOwner().equals(game.getPlayer1())) {
								cur = "ArmoredUp" + chara1;
							} else {
								cur = "ArmoredUp" + chara2;
							}
						} else {
							if (p.getOwner().equals(game.getPlayer1())) {
								cur = "ArmoredDown" + chara1;
							} else {
								cur = "ArmoredDown" + chara2;
							}
						}
						armored = p.getName() + " (Armored)" + p.getOwner().getName() + "The shield is " + shield;

						Board[i][j].setToolTipText(armored);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}						Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));
						// Board[i][j].setContentAreaFilled(false);

						// Board[i][j].setIcon(new ImageIcon);
					} else if (p instanceof Tech) {
						
						Board[i][j].setText(p.getName());

						String power = "Unused ";
						if (((Tech) p).isPowerUsed()) {
							power = "Used";
						}
						if (p.getOwner().equals(game.getPlayer1())) {
							cur = "Tech" + chara1;
						} else {
							cur = "Tech" + chara2;
						}

						tech = p.getName() + " (Tech) " + p.getOwner().getName() + "The power is " + power;
						Board[i][j].setToolTipText(tech);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}						Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));
						// Board[i][j].setContentAreaFilled(false);

						// Board[i][j].setIcon(new ImageIcon);
					} else if (p instanceof Medic) {
						Board[i][j].setText(p.getName());

						String power = "Unused ";
						if (((Medic) p).isPowerUsed()) {
							power = "Used";
						}
						if (p.getOwner().equals(game.getPlayer1())) {
							cur = "Medic" + chara1;
						} else {
							cur = "Medic" + chara2;
						}

						medic = p.getName() + " (Medic) " + p.getOwner().getName() + "The power is " + power;
						Board[i][j].setToolTipText(medic);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}						Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));
						// Board[i][j].setContentAreaFilled(false);

						// Board[i][j].setIcon(new ImageIcon);
					} else if (p instanceof Ranged) {
						 Board[i][j].setText(p.getName());

						String power = "Unused ";
						if (((Ranged) p).isPowerUsed()) {
							power = "Used";
						}
						if (p.getOwner().equals(game.getPlayer1())) {
							cur = "Ranged" + chara1;
						} else {
							cur = "Ranged" + chara2;
						}

						ranged = p.getName() + " (Ranged)" + p.getOwner().getName() + "The power is " + power;
						Board[i][j].setToolTipText(ranged);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}						Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));

					} else if (p instanceof Super) {
						 Board[i][j].setText(p.getName());

						String power = "Unused ";
						if (((Super) p).isPowerUsed()) {
							power = "Used";
						}
						if (p.getOwner().equals(game.getPlayer1())) { 
							cur = "Super"+chara1 ; 
						}
						else {
							cur = "Super"+chara2 ; 
						}
						superr = p.getName() + " (Super)" + p.getOwner().getName() + "The power is " + power;
						Board[i][j].setToolTipText(superr);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}					Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));
						
					} else if (p instanceof Speedster) {
						 Board[i][j].setText(p.getName());

						if (p.getOwner().equals(game.getPlayer1())) { 
							cur = "Speedster"+chara1 ; 
						}
						else {
							cur = "Speedster"+chara2 ; 
						}
						speedster = p.getName() + " (Speedster)" + p.getOwner().getName();
						Board[i][j].setToolTipText(speedster);
						Board[i][j].addActionListener(b);
						Board[i][j].addMouseListener(f);
						if (cur.charAt(cur.length()-1) !='f'){
							chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
									.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH))); 
							} 	
							else {
								chara.setIcon(new ImageIcon(this.getClass().getResource(cur)));
							}					
						Board[i][j].add(chara);
//						Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(cur))).getImage()
//								.getScaledInstance(120, 133, java.awt.Image.SCALE_SMOOTH)));
						
					}
				} else {
					Board[i][j].setText("n");

					 Board[i][j] = new JButton();
//					 if ((i+j)%2 == 0) { 
//							Board[i][j].setBackground(Color.LIGHT_GRAY);
//						}
//						else {
//							Board[i][j].setBackground(Color.DARK_GRAY);
//						}
					 if ((i+j)%2 == 0) { 
							Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell1.png"))).getImage()
									.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
						}
						else {
							Board[i][j].setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell2.png"))).getImage()
									.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));			
							}
					 chara= new JLabel() ; 
						Board[i][j].add(chara);

					Board[i][j].setContentAreaFilled(false );
					Board[i][j].addActionListener(b);
					Board[i][j].addMouseListener(f);

					// Board[i][j].setContentAreaFilled(false);

				}

			}
		}

		// for The Dead
		dead1 = new ArrayList<JButton>();
		for (int i = 0; i < 9; i++) {
			JButton cur = new JButton();
			String curr = "" ; 
			if ((i)%2 == 0) { 
				cur.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell1.png"))).getImage()
						.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			}
			else {
				cur.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell2.png"))).getImage()
						.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));			
				}
			cur.setContentAreaFilled(false );
			if (i < game.getPlayer1().getDeadCharacters().size()) {
				JLabel chara = new JLabel();

				Piece p = game.getPlayer1().getDeadCharacters().get(i);
				if (p instanceof SideKick) {
					curr = "SideKick" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}
					cur.add(chara) ; 
					cur.setText(p.getName());
					cur.setToolTipText(p.getName() + " (Sidekick)  " + '\n' + p.getOwner().getName());
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				}  else if (p instanceof Armored) {
					cur.setText(p.getName());

					String shield = "down";
					curr = "ArmoredDown" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ; 
					cur.setToolTipText(
							p.getName() + " (Armored)" + "\n" + p.getOwner().getName() + "The shield is " + shield);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Tech) {
					cur.setText(p.getName());
					curr = "Tech" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Tech) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Tech) " + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Medic) {
					cur.setText(p.getName());
					curr = "Medic" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Medic) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Medic) " + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Ranged) {
					cur.setText(p.getName());
					curr = "Ranged" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Ranged) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Ranged)" + " \n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Super) {
					cur.setText(p.getName());
					curr = "Super" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Super) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Super)" + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Speedster) {
					cur.setText(p.getName());
					curr = "Speedster" + chara1;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					cur.setToolTipText(p.getName() + " (Speedster)" + "\n " + p.getOwner().getName());
					cur.addActionListener(b);
					// Board[i][j].setIcon(new ImageIcon);
				}
			} else {
				cur = new JButton();
				cur.setContentAreaFilled(false);
				cur.setVisible(false);
			}
			cur.addActionListener(b);
			dead1.add(cur);

		}
//		//////////////////////////////////////////////////////////////////////////////////////////////////////
		dead2 = new ArrayList<JButton>();
		for (int i = 0; i < 9; i++) {
			JButton cur = new JButton();
			String curr = "" ; 
			if ((i)%2 == 0) { 
				cur.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell1.png"))).getImage()
						.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			}
			else {
				cur.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("cell2.png"))).getImage()
						.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));			
				}
			cur.setContentAreaFilled(false );
			if (i < game.getPlayer2().getDeadCharacters().size()) {
				JLabel chara = new JLabel();

				Piece p = game.getPlayer2().getDeadCharacters().get(i);
				if (p instanceof SideKick) {
					curr = "SideKick" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ; 
					cur.setText(p.getName());
					cur.setToolTipText(p.getName() + " (Sidekick)  " + '\n' + p.getOwner().getName());
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				}  else if (p instanceof Armored) {
					cur.setText(p.getName());

					String shield = "down";
					curr = "ArmoredDown" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ; 
					cur.setToolTipText(
							p.getName() + " (Armored)" + "\n" + p.getOwner().getName() + "The shield is " + shield);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Tech) {
					cur.setText(p.getName());
					curr = "Tech" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Tech) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Tech) " + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Medic) {
					cur.setText(p.getName());
					curr = "Medic" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					String power = "Unused ";
					if (((Medic) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Medic) " + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Ranged) {
					cur.setText(p.getName());
					curr = "Ranged" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}				cur.add(chara) ;
					String power = "Unused ";
					if (((Ranged) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Ranged)" + " \n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Super) {
					cur.setText(p.getName());
					curr = "Super" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}				cur.add(chara) ;
					String power = "Unused ";
					if (((Super) p).isPowerUsed()) {
						power = "Used";
					}
					cur.setToolTipText(
							p.getName() + " (Super)" + "\n " + p.getOwner().getName() + "The power is " + power);
					cur.addActionListener(b);

					// Board[i][j].setIcon(new ImageIcon);
				} else if (p instanceof Speedster) {
					cur.setText(p.getName());
					curr = "Speedster" + chara2;
					if (curr.charAt(curr.length() - 1) != 'f') {
						chara.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource(curr))).getImage()
								.getScaledInstance(120, 135, java.awt.Image.SCALE_SMOOTH)));
					} else {
						chara.setIcon(new ImageIcon(this.getClass().getResource(curr)));
					}					cur.add(chara) ;
					cur.setToolTipText(p.getName() + " (Speedster)" + "\n " + p.getOwner().getName());
					cur.addActionListener(b);
					// Board[i][j].setIcon(new ImageIcon);
				}
			} else {
				cur = new JButton();
				cur.setContentAreaFilled(false);
				cur.setVisible(false);
			}
			cur.addActionListener(b);
			dead2.add(cur);

		}
		view.getCurrentPlayer().setText(game.getCurrentPlayer().getName());
		view.getProgressBar1().setValue(game.getPlayer1().getPayloadPos());

		view.getProgressBar2().setValue(game.getPlayer2().getPayloadPos());
		if (game.getWinner() != null) {

			view.end("Woooohhoooo Congratulations " + game.getWinner().getName());

		}
		view.getDead1().setDead(dead1);
		view.getDead2().setDead(dead2);
		// for The Dead

		this.view.getBoard().setGrid(Board);
		TarBut.setBorder(new LineBorder(null));

		CurBut.setBorder(new LineBorder(null));
		move = false;
		usepower = false;
		Current = null;
		dir = null;
		target = null;
		tele = false;
		view.getUsePower().setEnabled(false);
		view.getHackRestore().setVisible(false);
//		view.getRestore().setVisible(false);
		view.getTeleport().setVisible(false);

	}

	private class TechAbil implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == view.getHackRestore()) {
				JOptionPane.showMessageDialog(null, "Please,choose the piece to be hacked or restore its ability!");
			}  else if (event.getSource() == view.getTeleport()) {
				tele = true;
				JOptionPane.showMessageDialog(null, "Please, choose the target and the new Location to teleport to  ");
			}

		}

	}

	private class Move implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			move = true;
		}

	}

	private class UsePower implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			usepower = true;
			if (Current instanceof Tech) {
				view.getHackRestore().setVisible(true);
//				view.getRestore().setVisible(true);
				view.getTeleport().setVisible(true);
			}
		}

	}

	private class HandleButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton[][] Board = view.getBoard().getGrid();

			if (!usepower) {
				CurBut.setBorder(new LineBorder(null));
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 6; j++) {
						if (event.getSource().equals(Board[i][j])) {
							Current = game.getCellAt(i, j).getPiece();
							CurBut = Board[i][j];
							
							Board[i][j].setBorder(new LineBorder(Color.YELLOW));
							break;
						}
					}
				}
				if (Current instanceof ActivatablePowerHero) {
					view.getUsePower().setEnabled(true);

				}
				target = null;

			} else {
				TarBut.setBackground(null);

				if (usepower && Current instanceof Tech && !tele) {
					TarBut.setBorder(new LineBorder(null));

					for (int i = 0; i < 7; i++) {
						for (int j = 0; j < 6; j++) {
							if (event.getSource() == Board[i][j]) {
								target = game.getCellAt(i, j).getPiece();
								TarBut = Board[i][j];
								Board[i][j].setBorder(new LineBorder(Color.GREEN));
								// Board[i][j].setBorder(new
								// LineBorder(Color.YELLOW));
								// Board[i][j].setOpaque(false);

							}
						}
					}
					try {
						((Tech) (Current)).usePower(null, target, null);
						Set();
					} catch (Exception e) {
						Set();
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (usepower && Current instanceof Tech && tele && target == null) {
					TarBut.setBorder(new LineBorder(null));

					for (int i = 0; i < 7; i++) {
						for (int j = 0; j < 6; j++) {
							if (event.getSource() == Board[i][j]) {
								target = game.getCellAt(i, j).getPiece();
								TarBut = Board[i][j];
								Board[i][j].setBorder(new LineBorder(Color.GREEN));
								// Board[i][j].setBorder(new
								// LineBorder(Color.YELLOW));
								// Board[i][j].setOpaque(false);
								break;

							}
						}
					}

				} else if (usepower && Current instanceof Tech && tele && target != null) {
					for (int i = 0; i < 7; i++) {
						for (int j = 0; j < 6; j++) {
							if (event.getSource() == Board[i][j]) {
								try {
									((Tech) (Current)).usePower(null, target, new Point(i, j));
									Set();
									break;
								} catch (Exception e) {
									Set();
									JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}

				} else if (Current instanceof Medic && usepower) {
					boolean flag = false;
					ArrayList<JButton> cur = dead1;
					ArrayList<JButton> No = dead2;
					if (game.getCurrentPlayer().equals(game.getPlayer2())) {
						cur = dead2;
						No = dead1;
					}
					if (game.getCurrentPlayer().equals(game.getPlayer1())) {

					}
					for (int i = 0; i < game.getCurrentPlayer().getDeadCharacters().size(); i++) {
						if (event.getSource() == cur.get(i)) {
							target = game.getCurrentPlayer().getDeadCharacters().get(i);
							flag = true;
							break;
						}
					}
					if (!flag) {
						for (int i = 0; i < game.getEnemyPlayer().getDeadCharacters().size(); i++) {
							if (event.getSource() == No.get(i)) {
								target = game.getEnemyPlayer().getDeadCharacters().get(i);
								flag = true;
								break;
							}
						}
						if (!flag ){
							for (int i = 0; i < 7; i++) {
								for (int j = 0; j < 6; j++) {
									if (event.getSource().equals(Board[i][j])) {
										target = game.getCellAt(i, j).getPiece();
										TarBut = Board[i][j];
										Board[i][j].setBorder(new LineBorder(Color.YELLOW));
										break;
									}
								}
							}
						}
					}
					
				}
			}

			if (!(Current instanceof ActivatablePowerHero)) {
				view.getUsePower().setEnabled(false);

			} else {
				view.getUsePower().setEnabled(true);

			}

		}

	}

	// private class Dead implements ActionListener {
	//
	// @Override
	// public void actionPerformed(ActionEvent event) {
	// if (event.getSource() == view.getDead1() ) {
	// for (int i = 0 ; i < game.getPlayer1().getDeadCharacters().size(); i ++ )
	// {
	// if (
	// game.getPlayer1().getDeadCharacters().get(i).getClass().getName().equals(view.getDead1().getSelectedItem()))
	// {
	// target = game.getPlayer1().getDeadCharacters().get(i) ;
	// break ;
	// }
	//
	// }
	// }
	// else if (event.getSource() == view.getDead2() ) {
	// for (int i = 0 ; i < game.getPlayer2().getDeadCharacters().size(); i ++ )
	// {
	// if (
	// game.getPlayer2().getDeadCharacters().get(i).getClass().getName().equals(view.getDead2().getSelectedItem()))
	// {
	// target = game.getPlayer2().getDeadCharacters().get(i) ;
	// break ;
	// }
	//
	// }
	// }
	// }
	//
	// }
	private class HandleDirection implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (move|| usepower ){
			try {
				if (event.getSource() == view.getDirections().getMoveDown()) {
					dir = Direction.DOWN;
				} else if (event.getSource() == view.getDirections().getMoveUp()) {
					dir = Direction.UP;
				} else if (event.getSource() == view.getDirections().getMoveRight()) {
					dir = Direction.RIGHT;
				} else if (event.getSource() == view.getDirections().getMoveLeft()) {
					dir = Direction.LEFT;
				} else if (event.getSource() == view.getDirections().getMoveDownLeft()) {
					dir = Direction.DOWNLEFT;
				} else if (event.getSource() == view.getDirections().getMoveDownRight()) {
					dir = Direction.DOWNRIGHT;
				} else if (event.getSource() == view.getDirections().getMoveUpLeft()) {
					dir = Direction.UPLEFT;
				} else if (event.getSource() == view.getDirections().getMoveUpRight()) {
					dir = Direction.UPRIGHT;
				}
				if (move) {
					Current.move(dir);
					Set();

				} else if (usepower) {
					if (!(Current instanceof Medic || Current instanceof Tech)) {
						((ActivatablePowerHero) (Current)).usePower(dir, null, null);
					} else if (Current instanceof Medic) {
						((Medic) (Current)).usePower(dir, target, null);
					}
					Set();

				}
			} catch (Exception e) {
				Set();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
			
		}
	}

	private class Rematch implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.dispose();
			new PlayTheGame();

		}

	}

	private class ClearHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Set();
		}

	}

	private class infoHandle implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			 if (Current instanceof Armored){
				 view.getInfo().setText(Armored );
			 }
			 else if (Current instanceof Medic){
				 view.getInfo().setText(Medic );
			 } 
			 else if (Current instanceof Ranged){
				 view.getInfo().setText(Ranged );
			 } 
			 else if (Current instanceof Speedster){
				 view.getInfo().setText(Speedster );
				 System.out.println("speedster");
			 }
			 else if (Current instanceof Super){
				 view.getInfo().setText(Super );
				 System.out.println("super");
			 }
			 else if (Current instanceof Tech){
				 view.getInfo().setText(Tech );
			 }
			 
			 else if (Current instanceof SideKick) { 
				 view.getInfo().setText(SideKick );
			 }
			 else {
				 view.getInfo().setText("");
			 }
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class LetStart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.Go();
			Set() ; 

		}

	}

	private class ChooseTeam implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.getChooseTheTeam().getSherif1()) {
				chara1 = "3.gif";
				choose1 = true;
			} else if (e.getSource() == view.getChooseTheTeam().getSherif2()) {
				chara2 = "3.gif";
				choose2 = true;

			} else if (e.getSource() == view.getChooseTheTeam().getMons1()) {
				chara1 = "1.png";
				choose1 = true;

			} else if (e.getSource() == view.getChooseTheTeam().getMons2()) {
				chara2 = "1.png";
				choose2 = true;

			} else if (e.getSource() == view.getChooseTheTeam().getGhoul1()) {
				chara1 = "2.png";
				choose1 = true;

			} else if (e.getSource() == view.getChooseTheTeam().getGhoul2()) {
				chara2 = "2.png";
				choose2 = true;

			}
			if (choose1 && choose2) {
				view.getChooseTheTeam().getLetStart().setEnabled(true);
			}
		}

	}
}

