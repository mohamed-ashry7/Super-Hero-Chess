package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class GUI extends JFrame  {
	endTheGame Ended ; 
	JPanel tecabi ; 
	Directions directions ;
	Board board ; 
	Start start ; 
	JButton usePower ; 
	JProgressBar progressBar1 ; 
	JProgressBar progressBar2 ;
	private JPanel right ; 
	private JPanel left ; 
	JButton HackRestore  ;
	JButton Teleport ; 
//	JButton Restore ; 
	JLabel currentPlayer ; 
	DeadChara dead1 ; 
	DeadChara dead2 ; 
	JLabel player1;
	JLabel player2;
	JLabel backg ;
	JPanel All ; 
	JButton Clear ; 
	JLabel info ; 
	ChooseTheTeam ChooseTheTeam ; 
	public DeadChara getDead1() {
		return dead1;
	}
	public void setDead1(DeadChara dead1) {
		this.dead1 = dead1;
	}
	public DeadChara getDead2() {
		return dead2;
	}
	public void setDead2(DeadChara dead2) {
		this.dead2 = dead2;
	}
	public Directions getDirections() {
		return directions;
	}
	public void setDirections(Directions directions) {
		this.directions = directions;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	public JButton getUsePower() {
		return usePower;
	}
	public void setUsePower(JButton usePower) {
		this.usePower = usePower;
	}
	public JProgressBar getProgressBar1() {
		return progressBar1;
	}
	public void setProgressBar1(JProgressBar progressBar1) {
		this.progressBar1 = progressBar1;
	}
	public JProgressBar getProgressBar2() {
		return progressBar2;
	}
	public void setProgressBar2(JProgressBar progressBar2) {
		this.progressBar2 = progressBar2;
	}
	public JLabel getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(JLabel currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	
	
	public GUI () { 
		this.setTitle("Super Hero Chess ");
		this.setIconImage(new ImageIcon((this.getClass().getResource("salah.jpg"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)) ; 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player1=new JLabel();
		player2=new JLabel();
		ChooseTheTeam = new ChooseTheTeam("","") ; 
		All = new JPanel() ; 
		this.setSize(1900, 1200);
		Ended = new endTheGame() ; 
		dead1= new DeadChara() ; 
		dead2 = new DeadChara() ; 
		HackRestore = new JButton ("Hack/Restore") ; 
		Teleport = new JButton("Teleport") ; 
//		Restore = new JButton("Restore") ; 
		HackRestore.setVisible(false );
		HackRestore.setToolTipText("This buttons allows you to hack an enemy or restore a friend ability ") ; 
		Teleport.setVisible(false );
//		Restore.setVisible(false );
		directions  = new Directions () ;
		board = new Board () ; 
		start = new Start() ; 
		usePower = new JButton() ; 
		usePower.setToolTipText("Use the Power and kill them H3h3h3");
		progressBar1  =new JProgressBar(JProgressBar.VERTICAL,0,6) ;
		progressBar2  =new JProgressBar(JProgressBar.VERTICAL,0,6) ;
		progressBar1.setStringPainted(true);
		progressBar1.setForeground(Color.GREEN);
		progressBar1.setToolTipText("Player 1 has scored " + progressBar1.getValue());
		progressBar2.setToolTipText("Player 2 has scored " + progressBar2.getValue());
		dead1.setToolTipText("Dead Characters of " + start.getPlayer1().getText());
		dead2.setToolTipText("Dead Characters of " + start.getPlayer2().getText());
		progressBar1.setOpaque(false);
		progressBar2.setOpaque(false);

		progressBar2.setStringPainted(true);
		progressBar2.setForeground(Color.GREEN);
		Clear = new JButton("Remove the taken action  ") ; 
		Clear.setToolTipText("to undo what you have choose ");
		this.progressBar1.setValue(0);
		this.progressBar2.setValue(0);

		this.start();

		
	}
	
	
	
	
	public JButton getClear() {
		return Clear;
	}
	public void setClear(JButton clear) {
		Clear = clear;
	}
//	public JButton getHackResotre() {
//		return HackRestore;
//	}
//	public void setHack(JButton hackRestore) {
//		HackRestore = hackRestore;
//	}
	public JButton getTeleport() {
		return Teleport;
	}
	public JButton getHackRestore() {
		return HackRestore;
	}
	public void setHackRestore(JButton hackRestore) {
		HackRestore = hackRestore;
	}
	public void setTeleport(JButton teleport) {
		Teleport = teleport;
	}
//	public JButton getRestore() {
//		return Restore;
//	}
//	public void setRestore(JButton restore) {
//		Restore = restore;
//	}
	public void Go () {
		this.remove(ChooseTheTeam);
		backg = new JLabel() ;
		backg.setSize(new Dimension(2000,1050)); 
		backg.setIcon(new ImageIcon(this.getClass().getResource("wood.png")));
		tecabi = new JPanel() ; 
		tecabi.setOpaque(false);
		All.setLayout(null);
//		player1=new JLabel(start.getPlayer1().getText());
//		player2=new JLabel(start.getPlayer2().getText());
		info = new JLabel () ; 
		player1.setOpaque(true);
		player2.setOpaque(true);
		player1.setFont(new Font("Serif",Font.BOLD,30));
		player2.setFont(new Font("Serif",Font.BOLD,30));
		tecabi.add(HackRestore) ;
		tecabi.add(Teleport) ;
//		tecabi.add(Restore) ;
		board.setBounds(550,80,800,850);
		currentPlayer.setBounds(910,20,150,50);
		currentPlayer.setForeground(Color.WHITE);
		currentPlayer.setBackground(Color.BLACK);
		currentPlayer.setOpaque(false );
		currentPlayer.setVerticalAlignment(SwingConstants.CENTER);
		currentPlayer.setFont(new Font("Sanserif",Font.BOLD,30)) ; 
		currentPlayer.setOpaque(false );
		player1.setBounds(1560, 30, 120,32);
//		All.add(player1);
		player2.setBounds(160, 30, 120,32);
//		All.add(player2);
		usePower.setContentAreaFilled(false );
		dead2.setBounds(30,80,400,364);
		Clear.setFont(new Font("Serif",Font.BOLD,20));
		Clear.setBounds(30, 80+364+10, 400, 50);
		info.setBounds(30,80+364+10+50+5,400,400);
		info.setFont(new Font ("Serif ",Font.BOLD,15));
		info.setForeground(Color.WHITE);
		dead1.setBounds(1450,80,400,365);
		progressBar2.setBounds(500,80,50,850);
		progressBar1.setBounds(1350,80,50,850);
		this.directions.setBounds(1520,470,250,182);
		this.usePower.setBounds(1592,700,100,100);
		
		usePower.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("eeee.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		this.tecabi.setBounds(1492,801,300,42);
		All.add(tecabi) ; 
		All.add(usePower) ; 
		All.add(this.directions);
		All.add(this.progressBar1);
		All.add(this.progressBar2);
		All.add(dead1);
		All.add(dead2);
		All.add(currentPlayer) ; 
		All.add(Clear);
		All.add(info);
		All.add(board);
		All.add(backg);
		this.add(All);
		this.repaint();
		this.revalidate();
	}
	public JLabel getInfo() {
		return info;
	}
	public void setInfo(JLabel info) {
		this.info = info;
	}
	public void  end (String msg) {
//		remove(tecabi) ; 
//		remove(usePower) ; 
//		remove(this.directions);
//		remove(this.progressBar1);
//		remove(this.progressBar2);
//		remove(dead1);
//		remove(dead2);
//		remove(currentPlayer) ; 
//		remove(board);
//		remove(player1);
//		remove(player2);
//		remove(backg) ;
		this.remove(All);
		this.getEnded().setWinner(msg);
		this.add(this.Ended) ; 
		this.repaint();
		this.revalidate();
	}
	public endTheGame getEnded() {
		return Ended;
	}
	public void setEnded(endTheGame ended) {
		Ended = ended;
	}

	public void start() {		
		add(start) ; 
		this.repaint();
		this.revalidate();
	}
	public void ChooseTheTeam () { 
		this.remove(start);
		String p1 = this.start.getPlayer1().getText() ; 
		String p2 = this.start.getPlayer2().getText() ; 

		ChooseTheTeam.getPlayer1().setText("<html>Choose your Team , " +p1) ; 
		ChooseTheTeam.getPlayer2().setText("<html>Choose your Team , " +p2) ; 
		add(ChooseTheTeam) ; 
		this.repaint();
		this.revalidate();
	}
	public ChooseTheTeam getChooseTheTeam() {
		return ChooseTheTeam;
	}
	public void setChooseTheTeam(ChooseTheTeam chooseTheTeam) {
		ChooseTheTeam = chooseTheTeam;
	}
//	public static void main(String[] args) {
//		GUI g = new GUI() ;
//		g.ChooseTheTeam("sdasd","dsad") ; 
////		g.start();
////		g.Go();
////		g.end("adssad");
//	}
	
	
	
		
	
	
}
