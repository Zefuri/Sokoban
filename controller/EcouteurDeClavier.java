package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Jeu;
import view.InterfaceGraphique;

public class EcouteurDeClavier extends KeyAdapter {
	private InterfaceGraphique ig;
	private Jeu jeu;

	public EcouteurDeClavier(Jeu jeu, InterfaceGraphique ig) {
		this.jeu = jeu;
		this.ig = ig;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		boolean isLevelCleared = false;

		switch (keyPressed) {
			case KeyEvent.VK_UP:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX(), jeu.niveau().getPousseurY() - 1);
				ig.getNiveauGraphique().changeSprite();
				break;
			case KeyEvent.VK_DOWN:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX(), jeu.niveau().getPousseurY() + 1);
				ig.getNiveauGraphique().changeSprite();
				break;
			case KeyEvent.VK_LEFT:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX() - 1, jeu.niveau().getPousseurY());
				ig.getNiveauGraphique().changeSprite();
				break;
			case KeyEvent.VK_RIGHT:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX() + 1, jeu.niveau().getPousseurY());
				ig.getNiveauGraphique().changeSprite();
				break;
			case KeyEvent.VK_F:
				ig.toggleFullscreen();
		}

		if (isLevelCleared) {
			if (!jeu.prochainNiveau()) {
				System.out.println("Tous les niveaux sont finis, veuillez fermer la fenêtre maître. uWu");
			}
		}
		e.getComponent().repaint();
	}
}
