package at.mschneider.appium.components;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import at.mschneider.appium.util.PageFactory;

/**
 * Page object for the item page
 */
public class ItemPage extends AbstractPage
{

    private static final String BUY_BUTTON = "com.thecarousell.Carousell:id/button_buy";

    /**
     * Go to the offer page
     * 
     * @return {@link OfferPage}
     */
    public OfferPage makeOffer()
    {
        confirmMessages();
        $(By.id(BUY_BUTTON)).click();
        return PageFactory.offerPage();
    }
}
