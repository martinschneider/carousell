package at.mschneider.appium.components;

import static at.mschneider.appium.util.SelectorHelper.byIdAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.ElementsCollection;

import io.appium.java_client.MobileBy;

/**
 * Abstract base class for page objects
 */
public class AbstractPage
{
    private static final String CHAT_MESSAGE = "com.thecarousell.Carousell:id/text_chat_action";
    private static final String CONFIRM_BUTTON = "com.thecarousell.Carousell:id/feature_button";

    /**
     * @param containerId resource-id of the container
     * @param textToFind text to match the elemnt by
     * @return the found {@link WebElement}
     */
    WebElement scrollIntoView(String containerId, String textToFind)
    {
        return $(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceIdMatches(\""
            + containerId
            + "\"))"
            + ".scrollIntoView(new UiSelector().textContains(\""
            + textToFind
            + "\"))"));
    }

    /**
     * Waits for the given amount of time
     *
     * @param timeUnit {@link TimeUnit}
     * @param duration waiting time the given time unit
     */
    void sleep(TimeUnit timeUnit, long duration)
    {
        try
        {
            timeUnit.sleep(duration);
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * Confirm all info messages
     */
    void confirmMessages()
    {
        ElementsCollection confirmationMessages;
        do
        {
            confirmationMessages = $$(byIdAndText(CONFIRM_BUTTON, "OK, Got it!"));
            for (WebElement confirmationMessage : confirmationMessages)
            {
                confirmationMessage.click();
            }
        } while (confirmationMessages.size() > 0);
    }

    /**
     * @return the text of the first chat action element TODO: should handle multiple chat messages, but this is good
     *         enough for now
     */
    String getInitialChatText()
    {
        return $(By.id(CHAT_MESSAGE)).getText();
    }
}
