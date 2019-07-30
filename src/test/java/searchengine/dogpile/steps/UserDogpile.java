package searchengine.dogpile.steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import searchengine.dogpile.pageobject.DogpileMainPage;
import searchengine.dogpile.pageobject.DogpileResultPage;

import java.util.List;

import static org.junit.Assert.assertThat;

public class UserDogpile {

    DogpileMainPage dogpileMainPage;
    DogpileResultPage dogpileResultPage;

    @Step
    public void go_to_dogpile() {
        dogpileMainPage.open();
    }

    @Step
    public void search_by_key_word(String keyword) {
        dogpileMainPage.enterKeyword(keyword);
        dogpileMainPage.performSearch();
    }

    @Step
    public void should_see_results_with_word(String expectedWord) {
        List<String> results = dogpileResultPage.getResults();
        results.replaceAll(String::toLowerCase);
        for (int i=0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        assertThat(results, Matchers.everyItem(Matchers.containsString(expectedWord)));
    }
}
