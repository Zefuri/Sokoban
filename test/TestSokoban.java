package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import global.Configuration;
import init.*;

public class TestSokoban {
	public static void main(String[] args) throws IOException {
		Configuration config = Configuration.instance();
		config.listConfigs();
		
		FileInputStream is;
		try {
			is = new FileInputStream("/home/c/ciprianu/eclipse-workspace/Sokoban/src/level.txt");
			LecteurNiveaux lecteur = new LecteurNiveaux(is);
			
			@SuppressWarnings("unused")
			ArrayList<Niveau> tousNiveaux = lecteur.lisTousNiveaux();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
