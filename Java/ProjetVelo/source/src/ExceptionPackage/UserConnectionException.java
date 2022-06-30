package ExceptionPackage;

public class UserConnectionException extends Exception {
    public String getMessage(){
        return "Error : email or password incorrect";
    }
}
