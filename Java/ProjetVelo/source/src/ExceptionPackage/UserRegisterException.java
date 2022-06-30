package ExceptionPackage;

public class UserRegisterException extends Exception {
    public String getMessage(String invalidFiled){
        return "Error : invalid field "+ invalidFiled;
    }
}
