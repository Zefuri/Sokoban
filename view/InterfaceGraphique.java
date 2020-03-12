package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.*;

import controller.EcouteurDeClavier;
import controller.EcouteurDeSouris;
import model.Jeu;

public class InterfaceGraphique implements Runnable {

	private JFrame frame;
	private boolean maximized;
	private Jeu jeu;
	NiveauGraphique niveauGraphique;
	
	public InterfaceGraphique(Jeu jeu) {
		this.jeu = jeu;
		this.niveauGraphique = null;
	}
	
	@Override
	public void run() {
		// Creation d'une fenetre
		frame = new JFrame("S oWo koban");
		maximized = false;

		try {
			niveauGraphique = new NiveauGraphique(jeu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(niveauGraphique);
		
		niveauGraphique.addMouseListener(new EcouteurDeSouris(jeu));
		frame.addKeyListener(new EcouteurDeClavier(jeu, this));

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
	
	public NiveauGraphique getNiveauGraphique() {
		return this.niveauGraphique;
	}
}
