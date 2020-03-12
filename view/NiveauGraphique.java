package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import model.Case;
import model.Jeu;

@SuppressWarnings("serial")
public class NiveauGraphique extends JComponent {
	private Jeu jeu;
	private ArrayList<ArrayList<Case>> grilleGraphique;
	private boolean sprite;
	
	private Image imgMur;
	private Image imgSol;
	private Image imgBut;
	private Image imgPousseur0;
	private Image imgPousseur1;
	private Image imgCaisse;
	private Image imgCaisseSurBut;

	public NiveauGraphique(Jeu jeu) throws IOException {
		super();
		this.jeu = jeu;
		this.grilleGraphique = null;
		this.sprite = false;
		
		InputStream in = null;
		
		in = getClass().getResourceAsStream("/view/images/Sol.png");
		imgSol = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/Mur.png");
		imgMur = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/But.png");
		imgBut = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/Pousseur0.png");
		imgPousseur0 = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/Pousseur1.png");
		imgPousseur1 = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/Caisse.png");
		imgCaisse = ImageIO.read(in);
		
		in = getClass().getResourceAsStream("/view/images/Caisse_sur_but.png");
		imgCaisseSurBut = ImageIO.read(in);
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

			Case current;

			for (int i = 0; i < this.jeu.niveau().getLignes(); i++) {
				for (int j = 0; j < this.jeu.niveau().getColonneMax(); j++) {
					if (j < this.jeu.niveau().getColonne(i)) {
						current = jeu.niveau().getCase(i, j);

						img = imgSol;
						drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);

						if (grilleGraphique == null || jeu.niveau().getCase(i, j) != grilleGraphique.get(i).get(j)) {
							switch (current) {
							case BUT:
								img = imgBut;
								break;
							case MUR:
								img = imgMur;
								break;
							case CAISSE:
								img = imgCaisse;
								break;
							case CAISSE_SUR_BUT:
								img= imgCaisseSurBut;
								break;
							case POUSSEUR:
								img = (sprite ? imgPousseur1 : imgPousseur0);
								break;
							case POUSSEUR_SUR_BUT:
								img = imgBut;
								drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);

								img = (sprite ? imgPousseur1 : imgPousseur0);
								break;
							default:
								break;
							}
						}
					} else {
						img = imgSol;
					}
					drawable.drawImage(img, j * imgWidth, i * imgHeight, imgWidth, imgHeight, null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeSprite() {
		sprite = !sprite;
	}
}
