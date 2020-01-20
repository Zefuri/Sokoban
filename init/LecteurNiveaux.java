package init;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LecteurNiveaux {
	
	private InputStream entree;
	private char currentChar;
	
	public LecteurNiveaux(InputStream is) {
		this.entree = is;
		try {
			this.currentChar = (char) this.entree.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Niveau lisProchainNiveau() throws UnknownCharacterInLevelFile, IOException {
		Niveau n = new Niveau();
		int i = 0;
		int j = 0;
		n.newLine(i);
		
		do {
			switch(this.currentChar) {
				case ' ' :
					n.addCase(i, j, Case.SOL);
					j++;
					break;
				case '#' :
					n.addCase(i, j, Case.MUR);
					j++;
					break;
				case '$' :
					n.addCase(i, j, Case.CAISSE);
					j++;
					break;
				case '.' :
					n.addCase(i, j, Case.BUT);
					j++;
					break;
				case '@' :
					n.addCase(i, j, Case.POUSSEUR);
					j++;
					break;
				case '*' :
					n.addCase(i, j, Case.CAISSE_SUR_BUT);
					j++;
					break;
				case '\n' :
					j = 0;
					i++;
					n.newLine(i);
					break;
				default :
					throw new UnknownCharacterInLevelFile("Caractère " + this.currentChar + " trouvé dans le fichier des niveaux.");
			}
			this.currentChar = (char) entree.read();
		} while (this.currentChar != ';');
		
		n.removeLine(i);
		entree.read(); // read space
		this.currentChar = (char) entree.read(); // read first digit
		String nom = new String("");
		do {
			nom += this.currentChar;
			this.currentChar = (char) entree.read();
		} while (this.currentChar != '\n');
		
		entree.read(); // consume last line 
		
		n.fixeNom(nom);
		
		return n;
	}
	
	public ArrayList<Niveau> lisTousNiveaux() {
		ArrayList<Niveau> tab = new ArrayList<>();
		
		try {
			while(this.entree.available() >= 1) {
				tab.add(this.lisProchainNiveau());
			}
		} catch (IOException | UnknownCharacterInLevelFile e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tab;
	}
	
	
}
