package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Directions extends JPanel {

	JButton moveUp;
	JButton moveDown;
	JButton moveRight;
	JButton moveLeft;
	JButton move ; 
	public JButton getMoveUp() {
		return moveUp;
	}

	public void setMoveUp(JButton moveUp) {
		this.moveUp = moveUp;
	}

	public JButton getMoveDown() {
		return moveDown;
	}

	public void setMoveDown(JButton moveDown) {
		this.moveDown = moveDown;
	}

	public JButton getMoveRight() {
		return moveRight;
	}

	public void setMoveRight(JButton moveRight) {
		this.moveRight = moveRight;
	}

	public JButton getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(JButton moveLeft) {
		this.moveLeft = moveLeft;
	}

	public JButton getMoveUpRight() {
		return moveUpRight;
	}

	public void setMoveUpRight(JButton moveUpRight) {
		this.moveUpRight = moveUpRight;
	}

	public JButton getMoveUpLeft() {
		return moveUpLeft;
	}

	public void setMoveUpLeft(JButton moveUpLeft) {
		this.moveUpLeft = moveUpLeft;
	}

	public JButton getMoveDownRight() {
		return moveDownRight;
	}

	public void setMoveDownRight(JButton moveDownRight) {
		this.moveDownRight = moveDownRight;
	}

	public JButton getMoveDownLeft() {
		return moveDownLeft;
	}

	public void setMoveDownLeft(JButton moveDownLeft) {
		this.moveDownLeft = moveDownLeft;
	}

	JButton moveUpRight;
	JButton moveUpLeft;
	JButton moveDownRight;
	JButton moveDownLeft;

	public Directions() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		moveUp = new JButton();
		moveDown = new JButton();
		moveRight = new JButton();
		moveLeft = new JButton();
		moveUpRight = new JButton();
		moveUpLeft = new JButton();
		moveDownRight = new JButton();
		moveDownLeft = new JButton();
		move = new JButton() ;
		move.setToolTipText("move it !");
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("up.png"));

		moveUp.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("up.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveDown.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("down.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveRight.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("right.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveLeft.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("left.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveUpRight.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("upright.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveUpLeft.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("upleft.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveDownRight.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("downright.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		moveDownLeft.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("downleft.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		move.setIcon(new ImageIcon(new ImageIcon((this.getClass().getResource("roro.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		move.setContentAreaFilled(false );
		moveUp.setContentAreaFilled(false);
		moveDown.setContentAreaFilled(false);
		moveRight.setContentAreaFilled(false);
		moveLeft.setContentAreaFilled(false);
		moveUpRight.setContentAreaFilled(false);
		moveUpLeft.setContentAreaFilled(false);
		moveDownRight.setContentAreaFilled(false);
		moveDownLeft.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(moveUp, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(moveRight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(moveLeft, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(moveDown, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(moveUpRight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(moveUpLeft, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(moveDownRight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(moveDownLeft, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(move,gbc) ; 

	}

	public JButton getMove() {
		return move;
	}

	public void setMove(JButton move) {
		this.move = move;
	}
}
