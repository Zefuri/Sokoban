package model.artifacts;

public class Noeud<Type> {
	private Type value;
	private Noeud<Type> prochain;
	
	
	public Noeud(Type value, Noeud<Type> prochain) {
		this.value = value;
		this.prochain = prochain;
	}
	
	public Type getValue() {
		return value;
	}
	public void setValue(Type value) {
		this.value = value;
	}
	public Noeud<Type> getProchain() {
		return prochain;
	}
	public void setProchain(Noeud<Type> prochain) {
		this.prochain = prochain;
	}
	
	
}
