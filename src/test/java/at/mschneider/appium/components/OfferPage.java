package at.mschneider.appium.components;

import static com.codeborne.selenide.Selenide.$;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import at.mschneider.appium.utils.ConfirmationDialog;
import at.mschneider.appium.utils.PageFactory;

/**
 * Page object for the offer page
 */
public class OfferPage extends AbstractPage
{

    private static final String SUBMIT_BUTTON = "com.thecarousell.Carousell:id/action_submit";
    private static final String AMOUNT_FIELD = "com.thecarousell.Carousell:id/text_offer";
    private static final String OFFER_TEXT = "MADE AN OFFER";
    private static final String CURRENCY_SYMBOL = "S$";

    /**
     * @param amount the amount to offer (will be rounded to two decimal places)
     * @return {@link OfferPage}
     */
    public OfferPage amount(BigDecimal amount)
    {
        WebElement amountField = $(By.id(AMOUNT_FIELD));
        amountField.clear();
        amountField.sendKeys(amount.setScale(2).toString());
        return this;
    }

    /**
     * @return the currently entered amount
     */
    public BigDecimal getAmount()
    {
        return new BigDecimal(stripCurrency($(By.id(AMOUNT_FIELD)).getText())).setScale(2);
    }

    /**
     * @param amountWithCurrency amount including a currency symbol
     * @return the amount without the currency symbol
     */
    private String stripCurrency(String amountWithCurrency)
    {
        // TODO: make a more generic version which works for different currencies
        return amountWithCurrency.replaceAll(Pattern.quote(CURRENCY_SYMBOL), "");
    }

    /**
     * Confirm the offer
     * 
     * @return {@link ConfirmationDialog}
     */
    public ConfirmationDialog submit()
    {
        $(By.id(SUBMIT_BUTTON)).click();
        return PageFactory.confirmationDialog();
    }

    /**
     * @param offerAmount amount of the offer
     * @return true, if an offer has successfully been made with the given amount
     */
    public boolean hasOfferBeenMade(BigDecimal offerAmount)
    {
        String chat = getInitialChatText();
        return chat.contains(OFFER_TEXT) && chat.contains(CURRENCY_SYMBOL) && chat.contains(offerAmount.toString());
    }

}
