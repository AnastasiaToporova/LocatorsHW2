package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SearchTests extends BaseTest {

    private String searchWord;

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[]{"lg", "apple", "blue"};
    }

    public SearchTests(String searchWord) {
        this.searchWord = searchWord;
    }

    @Test
    public void SearchResultItemsContainSearchWord() {
        storage.getPage(HomePage.class)
                .open()
                .setTextToSearchInput(searchWord)
                .clickResultLink();
        assertTrue(storage.getPage(ResultPage.class).checkSearchWordsInResults(searchWord));
    }
}
