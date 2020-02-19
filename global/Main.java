package global;

import java.io.FileNotFoundException;
import java.io.IOException;

import init.Jeu;
import view.InterfaceGraphique;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Jeu jeu = new Jeu();
		InterfaceGraphique ig = new InterfaceGraphique(jeu);
		ig.run();
	}

}
