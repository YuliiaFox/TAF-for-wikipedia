package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Page {

    @FindBy(css = "[name='search']")
    private WebElement searchInput;

    @FindBy(css = ".sprite.svg-search-icon")
    private WebElement searchBtn;

    @FindBy(css = "#searchLanguage")
    private WebElement languageOptions;

    public HomePage(WebDriver driver) {
       super(driver);
    }

    public HomePage checkHomePageLoaded(){
        assert(searchInput.isDisplayed());
        return this;
    }

    public HomePage setSearchInput(String text){
        searchInput.sendKeys(text);
        return this;
    }

    public SearchResultPage clickSearchBtn(){
        searchBtn.click();
        return new SearchResultPage(driver);
    }

    public HomePage setLanguageOptions(String lang){
        new Select(languageOptions).selectByValue(lang);
        return this;
    }
}