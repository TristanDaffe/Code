package ExceptionPackage;

public class AccessException extends Exception {

    public String getMessage() {
        return "failed to access data base ";
    }

}
