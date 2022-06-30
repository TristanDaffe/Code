package Test;

import ExceptionPackage.NullFieldException;
import ExceptionPackage.InvalidFieldException;
import ExceptionPackage.PhoneNumberFormatException;
import ModelPackage.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertThrows;


class UserTest {
    private User user;

    @BeforeEach
    void setUp() throws InvalidFieldException, NullFieldException, PhoneNumberFormatException {
        user = new User("test", "random", new GregorianCalendar(), "random@test.be", "pws", null, false, null);
    }

//adresse email
    @org.junit.jupiter.api.Test
    void setEmailAddress() throws InvalidFieldException, NullFieldException {
        user.setEmailAddress("test@random.be");
        Assert.assertEquals("test@random.be", user.getEmailAddress());
    }

    @org.junit.jupiter.api.Test
    void setEmailAddressInvalidException(){
        assertThrows(InvalidFieldException.class, () -> {
           user.setEmailAddress("test.test.test");
        });
    }

    @org.junit.jupiter.api.Test
    void setEmailAddressNullFieldException(){
        assertThrows(NullFieldException.class, () -> {
            user.setEmailAddress("");
        });
    }

//téléphone
    @org.junit.jupiter.api.Test
    void setPhoneNumber() throws PhoneNumberFormatException {
        user.setPhoneNumber("0499/999999");
        Assert.assertEquals("0499/999999", user.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumberEmpty() throws PhoneNumberFormatException {
        user.setPhoneNumber("");
        Assert.assertEquals(null, user.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumberInvalidField() {
        assertThrows(InvalidFieldException.class, () -> {
            user.setPhoneNumber("0499999999");
        });
    }
}