package searchengine.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.dogpile.com/")
public class DogpileMainPage extends PageObject {

    @FindBy(css = "#q")
    WebElementFacade searchBox;

    @FindBy(css = "#search > button")
    WebElementFacade searchButton;

    public void enterKeyword(String keyword) {
        searchBox.type(keyword);
    }

    public void performSearch() {
        searchButton.click();
    }

}
