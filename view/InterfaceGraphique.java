package view;

import java.io.IOException;

import javax.swing.*;

import init.Jeu;

public class InterfaceGraphique implements Runnable {

	@Override
	public void run() {
		// Creation d'une fenetre
		JFrame frame = new JFrame("S oWo koban");

		// Ajout de notre composant de dessin dans la fenetre
		try {
			frame.add(new NiveauGraphique(new Jeu()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// On fixe la taille et on demarre
		frame.setSize(800, 600);
		frame.setVisible(true);

	}

}
