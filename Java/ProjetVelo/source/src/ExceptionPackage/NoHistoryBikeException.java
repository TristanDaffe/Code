package ExceptionPackage;

public class NoHistoryBikeException extends Exception {
    @Override
    public String getMessage() {
        return "The bike has never been hire";
    }
}
