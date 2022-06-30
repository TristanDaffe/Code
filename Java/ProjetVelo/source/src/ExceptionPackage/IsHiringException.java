package ExceptionPackage;

public class IsHiringException extends Exception {
    public String getMessage(){
        return "You are already hiring a bike";
    }
}
