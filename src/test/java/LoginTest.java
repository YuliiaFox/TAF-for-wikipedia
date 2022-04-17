import Pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest {
    private final DriverWrapper wrapper = new DriverWrapper();

    @BeforeEach
    public void beforeEach(){
        wrapper.init("https://en.wikipedia.org/wiki/Main_Page");
    }

    @AfterEach
    public void afterEach(){
        wrapper.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/UsersCredentials.csv")
    public void userLoginsIntoPersonalAccount(String user, String password){
        MainPage mainPage = new MainPage(wrapper.getDriver())
                .checkMainPageLoaded()
                .checkUserNameLabelInvisible()
                .clickLoginBtn()
                .enterUserName(user)
                .enterPassword(password)
                .clickLogInBtn()
                .checkMainPageLoaded();
        Assertions.assertEquals(user, mainPage.getUserName());
    }
}