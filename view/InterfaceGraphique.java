package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.*;

import init.Jeu;

public class InterfaceGraphique implements Runnable {

	private JFrame frame;
	private boolean maximized;
	private Jeu jeu;
	
	public InterfaceGraphique(Jeu jeu) {
		this.jeu = jeu;
	}
	
	@Override
	public void run() {
		// Creation d'une fenetre
		frame = new JFrame("S oWo koban");
		maximized = false;

		NiveauGraphique niveauGraphique = new NiveauGraphique(jeu);
		frame.add(niveauGraphique);
		
		niveauGraphique.addMouseListener(new EcouteurDeSouris(jeu));
		frame.addKeyListener(new EcouteurDeClavier(jeu));

		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// On fixe la taille et on demarre
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public void toggleFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		if (maximized) {
			device.setFullScreenWindow(null);
			maximized = false;
		} else {
			device.setFullScreenWindow(frame);
			maximized = true;
		}
	}
	
}
