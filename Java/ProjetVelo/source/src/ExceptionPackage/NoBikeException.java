package ExceptionPackage;

public class NoBikeException extends Exception {
    @Override
    public String getMessage() {
        return "Error : no bike found";
    }
}
