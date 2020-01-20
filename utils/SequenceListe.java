package utils;

public class SequenceListe implements Sequence {
	
	private Noeud racine;
	private int taille;
	
	public SequenceListe() {
		this.racine = null;
		this.taille = 0;
	}
	
	public SequenceListe(int element) {
		this.racine = new Noeud(element, null);
		this.taille = 1;
	}

	@Override
	public void insereTete(int element) {
		this.racine = new Noeud(element, this.racine);
		this.taille++;
	}

	@Override
	public void insereQueue(int element) {
		Noeud noeudCourant = this.racine;
		for(int i = 0; i < this.taille-1; i++) {
			noeudCourant = noeudCourant.getProchain();
		}
		noeudCourant.setProchain(new Noeud(element, null));
		this.taille++;
	}

	@Override
	public int extraitTete() throws RuntimeException {
		if(taille == 0) {
			throw new RuntimeException("Séquence vide");
		} else {
			int value = this.racine.getValue();
			this.racine = this.racine.getProchain();
			this.taille--;
			return value;
		}
	}

	@Override
	public boolean estVide() {
		return (this.taille == 0);
	}

	@Override
	public String toString() {
		String res = new String("[");
		
		Noeud noeudCourant = this.racine;
		for(int i = 0; i < this.taille; i++) {
			res += noeudCourant.getValue();
			
			if(i + 1 < this.taille) {
				res += ", ";
			}
			
			noeudCourant = noeudCourant.getProchain();
		}
		
		res += "]";
		
		return res;
	}
	
	
}
