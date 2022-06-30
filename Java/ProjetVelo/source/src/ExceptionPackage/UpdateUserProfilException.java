package ExceptionPackage;

public class UpdateUserProfilException extends Exception{
    @Override
    public String getMessage() {
        return "Error : unable to change the profile information";
    }
}
