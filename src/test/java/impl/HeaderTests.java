package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeaderTests extends BaseTest {
    @Test
    public void checkSwitchThemeOfHeader() {

        assertEquals("#ffffff", storage.getPage(HomePage.class)
                .open()
                .clickSwitcherThemeHeader()
                .getColorHeader());
    }

    @Test
    public void checkSwitchLanguageOfPage() {

        assertEquals("uk", storage.getPage(HomePage.class)
                .open()
                .clickSwitcherLanguageHeader()
                .getLanguageOfPage());
    }
}
