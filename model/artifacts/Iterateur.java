package model.artifacts;

public interface Iterateur<Type> {
	public boolean aProchain();
	public Type prochain();
	public void supprime();
}
