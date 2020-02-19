package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import init.Case;
import init.Jeu;

@SuppressWarnings("serial")
public class NiveauGraphique extends JComponent {
	private Jeu jeu;
	private ArrayList<ArrayList<Case>> grilleGraphique;

	public NiveauGraphique(Jeu jeu) {
		super();
		this.jeu = jeu;
		this.grilleGraphique = null;
	}

	public void resetLevel() {
		grilleGraphique = null;
	}

	@Override
	protected void paintComponent(Graphics g) {
		try {
			Graphics2D drawable = (Graphics2D) g;
			int width = getSize().width;
			int height = getSize().height;
			int imgWidth = width / this.jeu.niveau().getColonneMax();
			int imgHeight = height / this.jeu.niveau().getLignes();

			Image img;
			InputStream in = null;

			Case current;

			for (int i = 0; i < this.jeu.niveau().getLignes(); i++) {
				for (int j = 0; j < this.jeu.niveau().getColonneMax(); j++) {
					if (j < this.jeu.niveau().getColonne(i)) {
						current = jeu.niveau().getCase(i, j);

						in = getClass().getResourceAsStream("/images/Sol.png");
						img = ImageIO.read(in);
						drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);

						if (grilleGraphique == null || jeu.niveau().getCase(i, j) != grilleGraphique.get(i).get(j)) {
							switch (current) {
							case BUT:
								in = getClass().getResourceAsStream("/images/But.png");
								break;
							case MUR:
								in = getClass().getResourceAsStream("/images/Mur.png");
								break;
							case CAISSE:
								in = getClass().getResourceAsStream("/images/Caisse.png");
								break;
							case CAISSE_SUR_BUT:
								in = getClass().getResourceAsStream("/images/Caisse_sur_but.png");
								break;
							case POUSSEUR:
								in = getClass().getResourceAsStream("/images/Pousseur.png");
								break;
							case POUSSEUR_SUR_BUT:
								in = getClass().getResourceAsStream("/images/But.png");
								img = ImageIO.read(in);
								drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);

								in = getClass().getResourceAsStream("/images/Pousseur.png");
								break;
							default:
								break;
							}
						}
					} else {
						in = getClass().getResourceAsStream("/images/Sol.png");
					}
					img = ImageIO.read(in);
					drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
