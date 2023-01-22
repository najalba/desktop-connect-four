package four;

public enum Symbol {
    X("X"), O("O"), EMPTY(" ");

    private final String code;

    Symbol(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
