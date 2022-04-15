import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class DriverWrapper {
    private WebDriver driver;

    public DriverWrapper() {
    }

    public void init(String url) {
        String browser = System.getProperty("browser");

        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                //TODO add no such browser exception
                throw new RuntimeException();
        }
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        this.driver.quit();
    }
}