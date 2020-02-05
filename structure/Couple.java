package structure;

public class Couple<Type> implements Comparable<Type> {
	private Type value;
	private int priority;
	
	public Couple(Type value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public Type getValue() {
		return value;
	}
	public void setValue(Type value) {
		this.value = value;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object arg0) {
		int res = 0;
		
		if(this.priority > ((Couple<Type>) arg0).getPriority()) {
			res = 1;
		} else if (this.priority < ((Couple<Type>) arg0).getPriority()){
			res = -1;
		}
		
		return res;
	}
	
}
