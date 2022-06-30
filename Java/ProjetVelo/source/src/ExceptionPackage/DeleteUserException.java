package ExceptionPackage;

public class DeleteUserException extends Exception {
    @Override
    public String getMessage() {
        return "Error : can't delete the user";
    }
}
