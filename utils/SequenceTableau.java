package utils;

import java.util.ArrayList;

public class SequenceTableau implements Sequence{
	
	private ArrayList<Integer> tableau;
	
	public SequenceTableau() {
		tableau = new ArrayList<>();
	}
	
	public SequenceTableau(int element) {
		tableau = new ArrayList<>();
		tableau.add(element);
	}

	@Override
	public void insereTete(int element) {
		tableau.add(0, element);
		
	}

	@Override
	public void insereQueue(int element) {
		tableau.add(element);
		
	}

	@Override
	public int extraitTete() throws RuntimeException {
		if(this.tableau.isEmpty()) {
			throw new RuntimeException("Séquence vide");
		} else {
			int value = tableau.get(0);
			tableau.remove(0);
			return value;
		}
	}

	@Override
	public boolean estVide() {
		return tableau.isEmpty();
	}

	@Override
	public String toString() {
		return this.tableau.toString();
	}
	
	

}
