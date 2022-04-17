package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends Page {

    @FindBy(css = "h1#firstHeading")
    private WebElement searchResultsLabel;

    @FindBy(css = "#ooui-php-1")
    private WebElement searchInput;

    @FindBy(css = ".mw-search-result")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getSearchResultLabelText(){
        return searchResultsLabel.getText();
    }

    public String getSearchInputText(){
        return searchInput.getText();
    }

    public List<WebElement> getSearchResults(){
        return searchResults;
    }

    public SearchResultPage checkSearchResultLabelIsDisplayed(){
        Assertions.assertTrue(searchResultsLabel.isDisplayed());
        return this;
    }
}
