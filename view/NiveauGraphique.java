package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import global.Configuration;
import global.Variables;
import init.Case;
import init.Jeu;

@SuppressWarnings("serial")
public class NiveauGraphique extends JComponent {
	private Jeu jeu;
	
	public NiveauGraphique(Jeu jeu) {
		super();
		this.jeu = jeu;
	}

	@Override
	protected void paintComponent(Graphics g) {
		try {
			Graphics2D drawable = (Graphics2D) g;
			int width = getSize().width;
			int height = getSize().height;
			int imgWidth = width / this.jeu.niveau().getLignes();
			int imgHeight = height / this.jeu.niveau().getColonnes();

			Image img;
			InputStream in = null;

			Case current;
			Configuration conf = Configuration.instance();

			for (int i = 0; i < this.jeu.niveau().getLignes(); i++) {
				for (int j = 0; j < this.jeu.niveau().getColonnes(); j++) {
					current = jeu.niveau().getCase(i, j);
					
					switch (current) {
					case BUT:
						in = new FileInputStream(conf.getProperty(Variables.IMG_BUT.getValue()));
						break;
					case MUR:
						in = new FileInputStream(conf.getProperty(Variables.IMG_MUR.getValue()));
						break;
					case CAISSE:
						in = new FileInputStream(conf.getProperty(Variables.IMG_CAISSE.getValue()));
						break;
					case CAISSE_SUR_BUT:
						in = new FileInputStream(conf.getProperty(Variables.IMG_C_SUR_B.getValue()));
						break;
					case SOL:
						in = new FileInputStream(conf.getProperty(Variables.IMG_SOL.getValue()));
						break;
					case POUSSEUR:
						in = new FileInputStream(conf.getProperty(Variables.IMG_POUSSEUR.getValue()));
						break;
					case POUSSEUR_SUR_BUT:
						in = new FileInputStream(conf.getProperty(Variables.IMG_POUSSEUR.getValue()));
						break;
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
