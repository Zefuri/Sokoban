package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Jeu;
import view.NiveauGraphique;

public class EcouteurDeSouris extends MouseAdapter {
	
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
}
