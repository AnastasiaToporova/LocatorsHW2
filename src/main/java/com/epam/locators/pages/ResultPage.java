package com.epam.locators.pages;

import com.epam.locators.utils.WaitUtils;
import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class ResultPage extends BasePage {
    public ResultPage() {
        PageFactory.initElements(getWebDriver(), this);
    }


    @Override
    public String getUrl() {
        return null;
    }

    @FindBy(xpath = "//div[contains(@class,'box__cur')]/span[@class='sum']")
    private List<WebElement> listPriceText;

    @FindBy(xpath = "//a[contains(@class,'card__title')]")
    private List<WebElement> linksResultsOfSearching;

    public boolean checkSearchWordsInResults(String searchWord) {
        WaitUtils.waitForPageLoad(getWebDriver());
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.urlContains(searchWord));
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOfAllElements(linksResultsOfSearching));
        return linksResultsOfSearching.stream().allMatch(link -> link.getText().toLowerCase().contains(searchWord));

    }

    public boolean checkPriseAscendingOrder() {
        List<Integer> listPrise = new ArrayList<>();
        for (WebElement span : listPriceText) {
            listPrise.add(Integer.valueOf(span.getText()));
        }
        return Ordering.natural().isOrdered(listPrise);
    }

    public boolean checkPriseDescendingOrder() {
        List<Integer> listPrise = new ArrayList<>();
        String[] text;
        for (WebElement span : listPriceText) {
            text = span.getText().split(" ");
            String result = text[0] + text[1];
            listPrise.add(Integer.valueOf(result));
        }

        return Ordering.natural().reverse().isOrdered(listPrise);
    }
}