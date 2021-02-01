package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.MainInfoAboutProductPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FeaturesOfProductTests extends BaseTest {

    @Test
    public void checkChangeColorOfSelectedProduct() {
        storage.getPage(HomePage.class).open().clickSelectedColorLink();
        assertTrue(storage.getPage(MainInfoAboutProductPage.class).checkColorsProduct());
    }
}
