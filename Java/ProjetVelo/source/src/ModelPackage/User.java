package ModelPackage;

import ExceptionPackage.NullFieldException;
import ExceptionPackage.InvalidFieldException;
import ExceptionPackage.PhoneNumberFormatException;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String lastName;
    private String firstName;
    private GregorianCalendar birthday;
    private String emailAddress;
    private Integer password;
    private String phoneNumber;
    private boolean agreeReceivePub;
    private String sponsor;

    private User(String lastName, String firstName, GregorianCalendar birthday, String emailAddress, String phoneNumber, boolean agreeReceivePub, String sponsor) throws NullFieldException, InvalidFieldException, PhoneNumberFormatException {
        setLastName(lastName);
        setFirstName(firstName);
        setBirthday(birthday);
        setEmailAddress(emailAddress);
        setPhoneNumber(phoneNumber);
        setAgreeReceivePub(agreeReceivePub);
        setSponsor(sponsor);
    }

    public User(String lastName, String firstName, GregorianCalendar birthday, String emailAddress, String password, String phoneNumber, boolean agreeReceivePub, String sponsor) throws NullFieldException, InvalidFieldException, PhoneNumberFormatException {
        this(lastName, firstName, birthday, emailAddress, phoneNumber, agreeReceivePub, sponsor);
        setPassword(password);
    }
    public User(String lastName, String firstName, GregorianCalendar birthday, String emailAddress, int password, String phoneNumber, boolean agreeReceivePub, String sponsor) throws NullFieldException, InvalidFieldException, PhoneNumberFormatException {
        this(lastName, firstName, birthday, emailAddress, phoneNumber, agreeReceivePub, sponsor);
        setPassword(password);
    }

    //region setteur
    public void setLastName(String lastName) throws NullFieldException {
        if(!lastName.isEmpty())
            this.lastName = lastName;
        else
            throw new NullFieldException("last name");
    }
    public void setFirstName(String firstName) throws NullFieldException {
        if(!firstName.isEmpty() && !firstName.isBlank()) {
            this.firstName = firstName;
        }
        else {
            throw new NullFieldException("first name");
        }
    }
    public void setBirthday(GregorianCalendar birthday) throws NullFieldException {
        if(birthday != null) {
            this.birthday = birthday;
        }
        else {
            throw new NullFieldException("birthday");
        }
    }
    public void setEmailAddress(String emailAddress) throws NullFieldException, InvalidFieldException {
        if(emailAddress.isBlank() || emailAddress.isEmpty()){
            throw new NullFieldException("email address");
        }
        Pattern emailPattern = Pattern.compile(".*@.*\\..*");
        Matcher emailMatcher = emailPattern.matcher(emailAddress);
        boolean matchFound = emailMatcher.find();

        if(matchFound)
            this.emailAddress = emailAddress;
        else
            throw new InvalidFieldException("email address");
    }
    private  void setPassword(String password) throws NullFieldException {
        if(!password.isBlank() && !password.isEmpty())
            this.password = password.hashCode();
        else
            throw new NullFieldException("password");
    }
    private void setPassword(int password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
        if(phoneNumber != null && !phoneNumber.isBlank() && !phoneNumber.isEmpty()){
            Pattern telPattern = Pattern.compile("04[0-9]{2}/[0-9]{6}");
            Matcher emailMatcher = telPattern.matcher(phoneNumber);
            boolean matchFound = emailMatcher.find();
            if(matchFound)
                this.phoneNumber = phoneNumber;
            else
                throw new PhoneNumberFormatException();
        }
        else{
            this.phoneNumber = null;
        }
    }
    public void setAgreeReceivePub(boolean agreeReceivePub) {
        this.agreeReceivePub = agreeReceivePub;
    }
    public void setSponsor(String sponsor) throws InvalidFieldException {
        if(sponsor != null && !sponsor.isEmpty()){
            Pattern emailPattern = Pattern.compile(".*@.*\\..*");
            Matcher emailMatcher = emailPattern.matcher(sponsor);
            boolean matchFound = emailMatcher.find();
            if(matchFound)
                this.sponsor = sponsor;
            else
                throw new InvalidFieldException("sponsor");
        }
    }
    //endregion

    //region getter
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public GregorianCalendar getBirthday() {
        return birthday;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Integer getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public boolean isAgreeReceivePub() {
        return agreeReceivePub;
    }
    public String getSponsor() {
        return sponsor;
    }

    //endregion
}
