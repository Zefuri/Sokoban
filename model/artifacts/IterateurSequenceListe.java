package model.artifacts;

public class IterateurSequenceListe<Type> implements Iterateur<Type> {

	private SequenceListe<Type> liste;
	private Noeud<Type> noeudCourant;
	private int pos;
	private boolean supprimable;

	public IterateurSequenceListe(SequenceListe<Type> liste) {
		this.liste = liste;
		this.noeudCourant = liste.getRacine();
		this.pos = 0;
		this.supprimable = false;
	}

	@Override
	public boolean aProchain() {
		return this.noeudCourant.getProchain() != null;
	}

	@Override
	public Type prochain() {
		if (!aProchain()) {
			throw new IllegalStateException("Pas de prochain à acceder");
		}
		Type value = this.noeudCourant.getValue();
		this.noeudCourant = this.noeudCourant.getProchain();
		this.pos++;
		this.supprimable = true;
		return value;
	}

	@Override
	public void supprime() {
		if (!this.supprimable) {
			throw new IllegalStateException("Interdiction de faire deux suppressions de suite");
		}
		if (this.pos == 1) {
			this.liste.setRacine(this.liste.getRacine().getProchain());
		} else {
			Noeud<Type> suppression = this.liste.getRacine();
			for (int i = 0; i < this.pos-2; i++) {
				suppression = suppression.getProchain();
			}
			suppression.setProchain(suppression.getProchain().getProchain());
		}
		this.pos--;
		this.supprimable = false;
	}
}
