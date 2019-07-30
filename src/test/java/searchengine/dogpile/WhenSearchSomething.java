package searchengine.dogpile;

import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import searchengine.dogpile.steps.UserDogpile;

public class WhenSearchSomething {

    @Steps
    UserDogpile juan;

    @Test
    public void should_see_relevant_results() {
        juan.go_to_dogpile();
        juan.search_by_key_word("rock nacional");
        juan.should_see_results_with_word("rock");
    }
}
