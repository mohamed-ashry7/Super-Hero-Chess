import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;

public class Version4View extends JFrame {

	Player p1;
	Player p2;
	Game game;
	JLabel nameCur ; 
	JPanel Dead ; 
	JButton remove ; 
	public Version4View() {
		/**
		 * Initializing a game object, where the first Player corresponds to p1
		 * object and the second player corresponds to p2 object
		 */
		p1 = new Player("player 1");
		p2 = new Player("player 2");
		game = new Game(p1, p2);
		/**
		 * Assigning a random player to be the current player which the game would start with. 
		 */
		int random = ((int) (2 * Math.random()));
		try {
			Field f = Game.class.getDeclaredField("currentPlayer");
			f.setAccessible(true);
			f.set(game, (random == 0) ? game.getPlayer1() : game.getPlayer2());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Adding 4 heroes to the Array of the DeadCharacters of the current player.
		 */
		try {
			Field f = Player.class.getDeclaredField("deadCharacters");
			f.setAccessible(true);
			ArrayList<Piece> newDead = new ArrayList<Piece>();
			newDead.add(new Super(null, game, "Super"));
			newDead.add(new Ranged(null, game, "Ranged"));
			newDead.add(new Speedster(null, game, "Speedster"));
			newDead.add(new Medic(null, game, "Medic"));
			Collections.shuffle(newDead);
			f.set((random == 0) ? game.getPlayer1() : game.getPlayer2(),
					newDead);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Your solution starts from here
		 */
		this.setLayout(null);
		this.setVisible(true );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(2000, 1000);
		RemoveHand h = new RemoveHand() ; 
		
		nameCur = new JLabel(game.getCurrentPlayer().getName()) ;  
		nameCur.setBounds(100,100,125,125);
		Dead = new JPanel(); 
		Dead.setBounds(100,500,700,125);
		remove = new JButton("Remove First ") ; 
		remove.setBounds(100,800,900,125);
		remove.addActionListener(h);
		for (int i =  0 ; i < game.getCurrentPlayer().getDeadCharacters().size() ; i ++ ) {
			JLabel dead = new JLabel(game.getCurrentPlayer().getDeadCharacters().get(i).getName()) ; 
			Dead.add(dead) ; 
			
		}
		this.add(nameCur,BorderLayout.NORTH);
		this.add(Dead,BorderLayout.CENTER) ; 
		this.add(remove, BorderLayout.SOUTH);
		repaint() ; 
		revalidate(); 
	}
	public static void main(String[] args) {
		Version4View v = new Version4View() ; 
	}
	private class RemoveHand implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (game.getCurrentPlayer().getDeadCharacters().size() >0 ) {
				game.getCurrentPlayer().getDeadCharacters().remove(0) ; 
				remove(Dead) ; 
				Dead = new JPanel() ;
				for (int i =  0 ; i < game.getCurrentPlayer().getDeadCharacters().size() ; i ++ ) {
					JLabel dead = new JLabel(game.getCurrentPlayer().getDeadCharacters().get(i).getName()) ; 
					Dead.add(dead) ; 
					
				}
				add(Dead) ; 
				Dead.setBounds(100,500,700,125);
				repaint() ; 
				revalidate();  
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry Bro there is no dead characters ");
			}
		} 
		
	}

}
