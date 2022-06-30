package ExceptionPackage;

public class NullFieldException extends Exception {
    private String nullField;

    public NullFieldException(String nullField) {
        this.nullField = nullField;
    }

    public String getMessage() {
        return "Error : "+ nullField +" can't be null";
    }
    public String toString(){
        return "NullFieldException";
    }
}
