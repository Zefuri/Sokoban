package model.artifacts;

import java.util.ArrayList;

public class SequenceTableau<Type> implements Sequence<Type>{
	
	private ArrayList<Type> tableau;
	
	public ArrayList<Type> getTableau() {
		return tableau;
	}

	public void setTableau(ArrayList<Type> tableau) {
		this.tableau = tableau;
	}

	public SequenceTableau() {
		tableau = new ArrayList<>();
	}
	
	public SequenceTableau(Type element) {
		tableau = new ArrayList<>();
		tableau.add(element);
	}

	@Override
	public void insereTete(Type element) {
		tableau.add(0, element);
		
	}

	@Override
	public void insereQueue(Type element) {
		tableau.add(element);
		
	}

	@Override
	public Type extraitTete() throws RuntimeException {
		if(this.tableau.isEmpty()) {
			throw new RuntimeException("Séquence vide");
		} else {
			Type value = tableau.get(0);
			tableau.remove(0);
			return value;
		}
	}

	@Override
	public boolean estVide() {
		return tableau.isEmpty();
	}


	@Override
	public Iterateur<Type> iterateur() {
		return new IterateurSequenceTableau<>(this);
	}

	@Override
	public String toString() {
		return this.tableau.toString();
	}
	

}
