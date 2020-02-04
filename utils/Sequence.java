package utils;

public interface Sequence<Type> {
	void insereTete(Type element);
	void insereQueue(Type element);
	Type extraitTete() throws RuntimeException;
	boolean estVide();
	Iterateur<Type> iterateur();
}
