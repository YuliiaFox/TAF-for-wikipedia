package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

    @FindBy(css = "#Welcome_to_Wikipedia")
    private WebElement welcomeToWikiLabel;

    @FindBy(css = "#pt-login")
    private WebElement loginBtn;

    @FindBy(css = "#pt-userpage")
    private WebElement userNameLabel;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage checkMainPageLoaded(){
        Assertions.assertTrue(welcomeToWikiLabel.isDisplayed());
        return this;
    }

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return new LoginPage(driver);
    }

    public MainPage checkUserNameLabelInvisible(){
        Assertions.assertTrue(driver.findElements(By.cssSelector("#pt-userpage")).isEmpty());
        return this;
    }

    public String getUserName(){
        return userNameLabel.getText();
    }
}