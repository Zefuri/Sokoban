package model;

public enum Variables {
	DEFAULT_PATH("DEFAULT_PATH"),
	
	LOGGER("Sokoban.Logger"),
	LOG_LEVEL("LogLevel"),
	LOG_INFO("INFO"),
	LOG_WARNING("WARNING"),
	LOG_SEVERE("SEVERE"),
	
	SEQUENCE("Sequence"),
	SEQ_TAB("Tableau"),
	SEQ_LISTE("Liste"),
	
	IMG_BUT("IMG_BUT"),
	IMG_CAISSE("IMG_CAISSE"),
	IMG_C_SUR_B("IMG_C_SUR_B"),
	IMG_MUR("IMG_MUR"),
	IMG_SOL("IMG_SOL"),
	IMG_POUSSEUR("IMG_POUSSEUR");
	
	private String value;
	
	Variables(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
