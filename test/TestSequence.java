package test;

import utils.Sequence;
import utils.SequenceListe;
import utils.SequenceTableau;

public class TestSequence {
	
	private Sequence s;
	
	public TestSequence(Sequence s) {
		this.s = s;
	}
	
	public void runTest() {
		this.s.insereTete(3);
		this.s.insereQueue(2);
		
		System.out.println("Vide ? " + this.s.estVide());
		
		System.out.println("liste : " + this.s);
		System.out.println("Extraction de la tete de liste : " + this.s.extraitTete());

		System.out.println("liste : " + this.s);
		System.out.println("Extraction de la tete de liste : " + this.s.extraitTete());
		
		System.out.println("liste : " + this.s);
		System.out.println("Extraction de la tete de liste : " + this.s.extraitTete());

		try {
			this.s.extraitTete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Vide ? " + this.s.estVide());
	}
	
	public static void main(String[] args) {
		TestSequence liste = new TestSequence(new SequenceListe(1));
		TestSequence tableau = new TestSequence(new SequenceTableau(1));
		
		liste.runTest();
		tableau.runTest();
	}
}
