package utils;

public interface Sequence {
	void insereTete(int element);
	void insereQueue(int element);
	int extraitTete() throws RuntimeException;
	boolean estVide();
}
