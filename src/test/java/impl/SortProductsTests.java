package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortProductsTests extends BaseTest {

    @Test
    public void checkSortProductByPriceAscending(){
        storage.getPage(HomePage.class).open().setTextToSearchInput("lg")
                .clickResultLink().clickSortProductsByAscending();
        assertTrue(storage.getPage(ResultPage.class).checkPriseAscendingOrder());
    }
    @Test
    public void checkSortProductByPriceDescending(){
        storage.getPage(HomePage.class).open().setTextToSearchInput("lg")
                .clickResultLink().clickSortProductsByDescending();

        assertTrue(storage.getPage(ResultPage.class).checkPriseDescendingOrder());
    }
}
