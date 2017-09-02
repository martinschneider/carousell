package at.mschneider.appium.components;

import static at.mschneider.appium.utils.SelectorHelper.byIdAndText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Page object for the confirmation dialog
 */
public class ConfirmationDialog
{
    private static final String YES_BUTTON = "android:id/button1";

    /**
     * click the "Yes" button
     */
    public void confirm()
    {
        $(byIdAndText(YES_BUTTON, "Yes")).click();
    }
}
