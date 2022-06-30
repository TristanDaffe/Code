package ExceptionPackage;

public class AddException extends Exception {
    private String modelFailedAdding;

    public AddException(String modelFailedAdding) {
        this.modelFailedAdding = modelFailedAdding;
    }

    public String getMessage() {
        return "Error : failed to add "+ modelFailedAdding;
    }
}
