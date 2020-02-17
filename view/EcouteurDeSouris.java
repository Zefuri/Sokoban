package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import init.Jeu;

public class EcouteurDeSouris implements MouseListener {
	
	private Jeu jeu;
	
	public EcouteurDeSouris(Jeu jeu) {
		this.jeu = jeu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		System.out.println("x = " + mouseX + ", y = " + mouseY);
		
		//TODO : faire la suite
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
