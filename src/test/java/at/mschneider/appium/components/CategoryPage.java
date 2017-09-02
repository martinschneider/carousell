package at.mschneider.appium.components;

import org.openqa.selenium.By;

import at.mschneider.appium.utils.PageFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page object for the search page
 */
public class CategoryPage extends AbstractPage
{

    private static final String PRODUCT_LINK = "com.thecarousell.Carousell:id/view_product";

    /**
     * Open the first item of the search results
     * 
     * @return {@link ItemPage}
     */
    public ItemPage openFirstItem()
    {
        confirmMessages();
        $(By.id(PRODUCT_LINK)).click();
        return PageFactory.itemPage();
    }
}
