package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
