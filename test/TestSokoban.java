package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import init.*;

public class TestSokoban {
	public static void main(String[] args) {
		FileInputStream is;
		try {
			is = new FileInputStream("/home/c/ciprianu/eclipse-workspace/Sokoban/src/level.txt");
			LecteurNiveaux lecteur = new LecteurNiveaux(is);
			
			@SuppressWarnings("unused")
			ArrayList<Niveau> tousNiveaux = lecteur.lisTousNiveaux();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
