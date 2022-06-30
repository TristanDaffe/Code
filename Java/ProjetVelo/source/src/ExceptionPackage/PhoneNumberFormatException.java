package ExceptionPackage;

public class PhoneNumberFormatException extends Exception {

        public String getMessage() {
            return "phone number invalide. Format :\n" +
                    "0412/345678";
        }

}
