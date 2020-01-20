package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import init.*;

public class testSokoban {
	public static void main(String[] args) {
		FileInputStream is;
		try {
			is = new FileInputStream("/home/c/ciprianu/eclipse-workspace/Sokoban/src/test/level.txt");
			LecteurNiveaux lecteur = new LecteurNiveaux(is);
			
			@SuppressWarnings("unused")
			ArrayList<Niveau> tousNiveaux = lecteur.lisTousNiveaux();
			System.out.println("debug");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
