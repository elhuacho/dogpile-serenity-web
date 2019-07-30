package searchengine.dogpile.pageobject;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class DogpileResultPage extends PageObject {

    public static final String RESULT_TITLE = ".web-bing__title";

    public List<String> getResults() {
        return findAll(RESULT_TITLE)
                .stream()
                .map(element -> element.getAttribute("textContext"))
                .collect(Collectors.toList());
    }

}
