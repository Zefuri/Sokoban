package model.artifacts;

import java.util.ArrayList;

public class FAP<Type> {
	private ArrayList<Couple<Type>> array;
	private int size;
	
	public FAP() {
		array = new ArrayList<>();
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insert(Type value, int priority) {
		Couple<Type> couple = new Couple<>(value, priority);
		int i = 0;
		while(i < size && (array.get(i).compareTo(couple)) == 0) {
			i++;
		} // i >= size || array.get(i).getPriority() <= priority
		array.add(i, couple);
		size++;
	}
	
	public Type extract() {
		size--;
		return array.remove(0).getValue();
	}
	
}
