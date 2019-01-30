
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
            public void testLogin(){
        EnterButton();
        insertName();
        insertPass();
        loginButton2();
    }

}
