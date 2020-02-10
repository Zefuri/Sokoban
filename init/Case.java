package init;

public enum Case {
	SOL(' '),
	MUR('#'),
	CAISSE('$'),
	BUT('.'),
	POUSSEUR('@'),
	POUSSEUR_SUR_BUT('+'),
	CAISSE_SUR_BUT('*');
	
	private final char id;
    private Case(char id) {
        this.id = id;
    }

    public char id() {
        return this.id;
    }
}
