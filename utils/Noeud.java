package utils;

public class Noeud {
	private int value;
	private Noeud prochain;
	
	
	public Noeud(int value, Noeud prochain) {
		this.value = value;
		this.prochain = prochain;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Noeud getProchain() {
		return prochain;
	}
	public void setProchain(Noeud prochain) {
		this.prochain = prochain;
	}
	
	
}
