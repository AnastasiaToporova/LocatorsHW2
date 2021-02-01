package impl;

import api.BaseTest;
import com.epam.locators.pages.CardPage;
import com.epam.locators.pages.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddToCartTests extends BaseTest {

    @Test
    public void checkAmountOfProductInCard() {
        storage.getPage(HomePage.class)
                .open()
                .clickAddToCardButton();
        storage.getPage(CardPage.class)
                .clickComebackButton();
        assertEquals("1", storage.getPage(HomePage.class).getAmountOfGoodsInTheCardText());
        storage.getPage(HomePage.class)
                .clickAddToCardPhoneButton();
        storage.getPage(CardPage.class)
                .clickComebackButton();
        assertEquals("2", storage.getPage(HomePage.class).getAmountOfGoodsInTheCardText());

    }

    @Test
    public void checkCardPopupElements() {
        storage.getPage(HomePage.class).open().clickAddToCardButton();
        assertTrue(storage.getPage(CardPage.class).checkoutOrderButtonIsDisplayed());
        assertTrue(storage.getPage(CardPage.class).priceTextIsDisplayed());
        assertTrue(storage.getPage(CardPage.class).closeIconIsDisplayed());
        assertTrue(storage.getPage(CardPage.class).HeaderTitleCardIsDisplayed());
        assertTrue(storage.getPage(CardPage.class).comebackToGoodsButtonIsDisplayed());
    }
}
