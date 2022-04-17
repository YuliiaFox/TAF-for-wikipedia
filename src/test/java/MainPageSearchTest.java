import Pages.HomePage;
import Pages.SearchResultPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class MainPageSearchTest {

    private final DriverWrapper wrapper = new DriverWrapper();

    @BeforeEach
    public void beforeEach(){
        wrapper.init("https://www.wikipedia.org/");
    }

    @AfterEach
    public void afterEach(){
        wrapper.close();
    }

    @org.junit.jupiter.api.Test
    public void checkMainPageSearch (){
        HomePage homePage = new HomePage(wrapper.getDriver());
        SearchResultPage searchResultPage = homePage
                .checkHomePageLoaded()
                .setSearchInput("search hjb")
                .clickSearchBtn()
                .checkSearchResultLabelIsDisplayed();
        Assertions.assertEquals( 20, searchResultPage.getSearchResults().size());
    }
}