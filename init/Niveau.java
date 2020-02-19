package init;
import java.util.ArrayList;

public class Niveau {
	
	private String nom;
	private ArrayList<ArrayList<Case>> grille;
	private int pousseurX;
	private int pousseurY;
	
	public Niveau() {
		this.grille = new ArrayList<>();
	}
	
	public void fixeNom(String s) {
		this.nom = s;
	}
	public int getPousseurX() {
		return pousseurX;
	}

	public void setPousseurX(int pousseurX) {
		this.pousseurX = pousseurX;
	}

	public int getPousseurY() {
		return pousseurY;
	}

	public void setPousseurY(int pousseurY) {
		this.pousseurY = pousseurY;
	}
	
	/* ----- USELESS ----- */
	public void videCase(int i, int j) {
		this.grille.get(i).add(j, Case.SOL);
	}
	
	public void ajouteMur(int i, int j) {
		this.grille.get(i).add(j, Case.MUR);
	}
	
	public void ajoutePousseur(int i, int j) {
		this.grille.get(i).add(j, Case.POUSSEUR);
	}
	
	public void ajouteCaisse(int i, int j) {
		this.grille.get(i).add(j, Case.CAISSE);
	}
	
	public void ajouteBut(int i, int j) {
		this.grille.get(i).add(j, Case.BUT);
	}
	/* ----- ------- ----- */
	
	public void addCase(int i, int j, Case c) {
		this.grille.get(i).add(j, c);
	}
	
	public int getColonneMax() {
		int max = 0;
		for(int i = 0; i < this.grille.size(); i++) {
			if(max < this.grille.get(i).size()) {
				max = this.grille.get(i).size();
			}
		}
		return max;
	}
	
	public int getColonne(int i) {
		return grille.get(i).size();
	}
	
	public int getLignes() {
		return this.grille.size();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/* ----- USELESS ----- */
	public boolean estVide(int l, int c) {
		return (this.grille.get(c).get(l) == Case.SOL);
	}
	
	public boolean aMur(int l, int c) {
		return (this.grille.get(c).get(l) == Case.MUR);
	}
	
	public boolean aPousseur(int l, int c) {
		return (this.grille.get(c).get(l) == Case.POUSSEUR);
	}
	
	public boolean aCaisse(int l, int c) {
		return (this.grille.get(c).get(l) == Case.CAISSE);
	}
	
	public boolean aBut(int l, int c) {
		return (this.grille.get(c).get(l) == Case.BUT);
	}
	/* ----- ------- ----- */
	
	public boolean isFromType(int i, int j, Case c) {
		return (this.grille.get(i).get(j) == c);
	}
	
	public void newLine(int i) {
		this.grille.add(i, new ArrayList<Case>());
	}
	
	public void removeLine(int i) {
		this.grille.remove(i);
	}
	
	public Case getCase(int i, int j) {
		return this.grille.get(i).get(j);
	}
	
	public void setCase(int i, int j, Case c) {
		this.grille.get(i).set(j, c);
	}
	
	public void move(int i, int j) {  // invert i and j !!!
		Case current = getCase(pousseurY, pousseurX);
		Case future = getCase(j, i);
		
		if (future == Case.CAISSE || future == Case.CAISSE_SUR_BUT) {
			int nextCaisseX = i+(i-pousseurX);
			int nextCaisseY = j+(j-pousseurY);
			Case nextCaisse = getCase(nextCaisseY, nextCaisseX);
			
			if (canMove(nextCaisse)) {
				if (future == Case.CAISSE_SUR_BUT) {
					setCase(j, i, Case.BUT);
				} else {
					setCase(j, i, Case.SOL);
				}
				
				if (nextCaisse == Case.BUT) {
					setCase(nextCaisseY, nextCaisseX, Case.CAISSE_SUR_BUT);
				} else {
					setCase(nextCaisseY, nextCaisseX, Case.CAISSE);
				}
				
				future = getCase(j, i);
			}
		}
		
		if (canMove(future)) {
			if (current == Case.POUSSEUR_SUR_BUT) {
				setCase(pousseurY, pousseurX, Case.BUT);
			} else {
				setCase(pousseurY, pousseurX, Case.SOL);
			}
			
			pousseurX = i;
			pousseurY = j;
			
			if (future == Case.BUT) {
				setCase(pousseurY, pousseurX, Case.POUSSEUR_SUR_BUT);
			} else {
				setCase(pousseurY, pousseurX, Case.POUSSEUR);
			}
		}
	}
	
	public boolean canMove(Case c) {
		return (c != Case.CAISSE && c != Case.MUR && c != Case.CAISSE_SUR_BUT);
	}
}
