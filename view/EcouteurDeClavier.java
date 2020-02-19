package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import init.Jeu;

public class EcouteurDeClavier implements KeyListener {

	private Jeu jeu;

	public EcouteurDeClavier(Jeu jeu) {
		this.jeu = jeu;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		boolean isLevelCleared = false;

		switch (keyPressed) {
			case KeyEvent.VK_UP:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX(), jeu.niveau().getPousseurY() - 1);
				break;
			case KeyEvent.VK_DOWN:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX(), jeu.niveau().getPousseurY() + 1);
				break;
			case KeyEvent.VK_LEFT:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX() - 1, jeu.niveau().getPousseurY());
				break;
			case KeyEvent.VK_RIGHT:
				isLevelCleared = jeu.niveau().move(jeu.niveau().getPousseurX() + 1, jeu.niveau().getPousseurY());
				break;
		}

		if (isLevelCleared) {
			if (!jeu.prochainNiveau()) {
				System.out.println("Tous les niveaux sont finis, veuillez fermer la fenêtre maître. uWu");
			}
		}
		e.getComponent().repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
