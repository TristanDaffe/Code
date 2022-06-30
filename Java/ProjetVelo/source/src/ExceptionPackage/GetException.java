package ExceptionPackage;

public class GetException extends Exception {
    private String modelFailedGetting;

    public GetException(String modelFailedGetting) {
        this.modelFailedGetting = modelFailedGetting;
    }

    public String getMessage() {
        return "Error : failed to find "+ modelFailedGetting;
    }
}
