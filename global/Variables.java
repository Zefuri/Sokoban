package global;

public enum Variables {
	DEFAULT_PATH("/home/f/fodorg/eclipse-workspace/Sokoban/src/defaut.cfg"),
	
	LOGGER("Sokoban.Logger"),
	LOG_LEVEL("LogLevel"),
	LOG_INFO("INFO"),
	LOG_WARNING("WARNING"),
	LOG_SEVERE("SEVERE"),
	
	SEQUENCE("Sequence"),
	SEQ_TAB("Tableau"),
	SEQ_LISTE("Liste");
	
	private String value;
	
	Variables(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
