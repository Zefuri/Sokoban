package init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Jeu {
	private ArrayList<Niveau> niveaux;
	private int indexNiveau;

	public Jeu() throws FileNotFoundException, IOException {
		InputStream is = getClass().getResourceAsStream("/level.txt");
		LecteurNiveaux lecteur = new LecteurNiveaux(is);
		
		this.niveaux = lecteur.lisTousNiveaux();
		
		is.close();
		
		this.indexNiveau = 0;
	}
	
	public Niveau niveau() {
		return this.niveaux.get(this.indexNiveau);
	}
	
	public boolean prochainNiveau() {	
		boolean res = (this.indexNiveau+1 < this.niveaux.size());
		
		if(res) {
			this.indexNiveau++;
		}
		
		return res;
	}
}
