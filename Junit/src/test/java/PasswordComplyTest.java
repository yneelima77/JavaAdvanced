import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordComplyTest {
    @Test
    void testDoesPasswordComply() {
        boolean expectedResult = true;
        PasswordComply passwordComply = new PasswordComply("abcd1234");
        boolean actualResult = passwordComply.doesPasswordComply();
        assertEquals(expectedResult, actualResult, "Password conditions failed!");
        System.out.println("Password conditions success!");
    }

    @Test
    void testDoesPasswordExist() {
        PasswordComply password = new PasswordComply("abcd1234");
        assertThrows(java.sql.SQLException.class, () -> password.doesNotAlreadyExist(), "SQL Exception was thrown.");
    }

    @Test
    void testEmptyPassword() {
        PasswordComply password = new PasswordComply("Abcd1234!");
        assertThrows(NullPointerException.class, () -> password.doesNotAlreadyExist(), "Null Exception was thrown but received SQL Exception.");
    }

}
