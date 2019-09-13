package Run;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

import controller.Control;
import model.game.Game;
import model.game.Player;
import view.GUI;

public class PlayTheGame  {
//	String name1 ; 
//	String name2 ;
	GUI view ; 
	Game game ; 
//	public void playSound(String soundFile) throws LineUnavailableException, MalformedURLException, UnsupportedAudioFileException, IOException {
//	    File f = new File("./" + soundFile);
//	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(soundFile));  
//	    Clip clip = AudioSystem.getClip();
//	    clip.open(audioIn);
//	    clip.start();
//	}
	
	
	public PlayTheGame () {
		playHandle pp = new playHandle() ; 
		view = new GUI() ; 
		view.getStart().getPlay().addActionListener(pp); 


	}

	public static void main(String[] args) throws LineUnavailableException, MalformedURLException, UnsupportedAudioFileException, IOException {

		PlayTheGame play = new PlayTheGame() ; 
	}
	
	private class playHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			game = new Game(new Player (view.getStart().getPlayer1().getText()),new Player (view.getStart().getPlayer2().getText()) ) ;
			view.setCurrentPlayer(new JLabel(view.getStart().getPlayer1().getText())); 
			view.getCurrentPlayer().setSize(new Dimension(150 ,150));
			Control c = new Control( game ,view ) ; 
			view.ChooseTheTeam();

		} 
		
	}
	
}
