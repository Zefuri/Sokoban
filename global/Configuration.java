package global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import init.Niveau;
import structure.Sequence;
import structure.SequenceListe;
import structure.SequenceTableau;

public class Configuration {
	private static Configuration instance = null;
	private Properties config;
	
	private Configuration() throws IOException {
		FileInputStream fDefaultConfig = (FileInputStream) getClass().getResourceAsStream("/defaut.cfg");
		Properties defaultConfig = new Properties();
		defaultConfig.load(fDefaultConfig);
		
		String homePath = System.getProperty("user.home");
		try {
			FileInputStream fUserFile = new FileInputStream(homePath + "/.sokoban.cfg"); // if the file doesn't exist, go to catch statement
			config = new Properties(defaultConfig);
			config.load(fUserFile);
		} catch (FileNotFoundException e) {
			config = new Properties(defaultConfig);
		}
	}
	
	public static Configuration instance() throws IOException {
		if(instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	
	public Logger logger() {
		Logger logger = Logger.getLogger(Variables.LOGGER.getValue());
		logger.setLevel(Level.parse(instance.config.getProperty(Variables.LOG_LEVEL.getValue())));
		return logger;
	}
	
	public Sequence<Niveau> nouvelleSequence() {
		Sequence<Niveau> res = null;
		
		if(getProperty(Variables.SEQUENCE.getValue()).equals(Variables.SEQ_TAB.getValue())) {
			res = new SequenceTableau<Niveau>();
		} else {
			res = new SequenceListe<Niveau>();
		}
		
		return res;
	}

	public String getProperty(String key) {
		return config.getProperty(key);
	}
	
	public Object setProperty(String key, String value) {
		return config.setProperty(key, value);
	}
	
	public void listConfigs() {
		config.list(System.out);
	}
}
