package ExceptionPackage;

public class InvalidFieldException extends Exception{
    private String unvalidField;

    public InvalidFieldException(String unvalidField) {
        this.unvalidField = unvalidField;
    }

    public String getMessage(){
        return "Error : invalid "+ unvalidField +" field";
    }
}
