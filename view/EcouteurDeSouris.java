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
	
		
		int blockWidth = e.getComponent().getSize().width / jeu.niveau().getColonneMax();
		int blockHeight = e.getComponent().getSize().height / jeu.niveau().getLignes();
		
		int posX = mouseX/blockWidth;
		int posY = mouseY/blockHeight;
		
		if ((posX == jeu.niveau().getPousseurX()-1 || posX == jeu.niveau().getPousseurX()+1) && (posY == jeu.niveau().getPousseurY())
			|| (posY == jeu.niveau().getPousseurY()-1 || posY == jeu.niveau().getPousseurY()+1) && (posX == jeu.niveau().getPousseurX())) { // user clicked next to the pusher
			
			if (jeu.niveau().move(posX, posY)) {
				((NiveauGraphique) e.getComponent()).resetLevel();
				if (!jeu.prochainNiveau()) {
					System.out.println("Tous les niveaux sont finis, veuillez fermer la fenêtre maître. uWu");
				}
			}
		}
		e.getComponent().repaint();
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
