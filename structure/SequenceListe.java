package structure;

public class SequenceListe<Type> implements Sequence<Type> {
	
	private Noeud<Type> racine;
	private int taille;
	
	public SequenceListe() {
		this.racine = null;
		this.taille = 0;
	}
	
	public SequenceListe(Type element) {
		this.racine = new Noeud<>(element, null);
		this.taille = 1;
	}

	public Noeud<Type> getRacine() {
		return racine;
	}

	public void setRacine(Noeud<Type> racine) {
		this.racine = racine;
	}

	@Override
	public void insereTete(Type element) {
		this.racine = new Noeud<>(element, this.racine);
		this.taille++;
	}

	@Override
	public void insereQueue(Type element) {
		Noeud<Type> noeudCourant = this.racine;
		for(int i = 0; i < this.taille-1; i++) {
			noeudCourant = noeudCourant.getProchain();
		}
		noeudCourant.setProchain(new Noeud<>(element, null));
		this.taille++;
	}

	@Override
	public Type extraitTete() throws RuntimeException {
		if(taille == 0) {
			throw new RuntimeException("Séquence vide");
		} else {
			Type value = this.racine.getValue();
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
	public Iterateur<Type> iterateur() {
		return new IterateurSequenceListe<>(this);
	}

	@Override
	public String toString() {
		String res = new String("[");
		
		Noeud<Type> noeudCourant = this.racine;
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
