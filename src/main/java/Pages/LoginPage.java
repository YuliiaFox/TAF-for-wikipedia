package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    @FindBy(css = "[name='wpName']")
    private WebElement userNameField;

    @FindBy(css = "[name='wpPassword']")
    private WebElement passwordField;

    @FindBy(css = "#wpLoginAttempt")
    private WebElement logInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUserName(String username){
        userNameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String pass){
        passwordField.sendKeys(pass);
        return this;
    }

    public MainPage clickLogInBtn(){
        logInBtn.click();
        return new MainPage(driver);
    }
}
