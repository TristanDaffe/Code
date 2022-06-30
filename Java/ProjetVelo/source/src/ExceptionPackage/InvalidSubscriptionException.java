package ExceptionPackage;

public class InvalidSubscriptionException extends Exception {
    @Override
    public String getMessage() {
        return "your subscription doesn't allow you to hire this type of bike";
    }
}
