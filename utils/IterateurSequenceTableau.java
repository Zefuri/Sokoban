package utils;

public class IterateurSequenceTableau implements Iterateur {
	
	private SequenceTableau tableau;
	private int pos;
	private boolean supprimable;
	
	public IterateurSequenceTableau(SequenceTableau tableau) {
		this.tableau = tableau;
		this.pos = 0;
		this.supprimable = false;
	}

	@Override
	public boolean aProchain() {
		return this.tableau.getTableau().size() > this.pos+1;
	}

	@Override
	public int prochain() {
		if (!aProchain()) {
			throw new IllegalStateException("Pas de prochain à acceder");
		}
		this.pos++;
		this.supprimable = true;
		return this.tableau.getTableau().get(this.pos-1);
	}

	@Override
	public void supprime() {
		if (!this.supprimable) {
			throw new IllegalStateException("Interdiction de faire deux suppressions de suite");
		}
		this.supprimable = false;
		this.tableau.getTableau().remove(this.pos-1);
		this.pos--;
	}

}
