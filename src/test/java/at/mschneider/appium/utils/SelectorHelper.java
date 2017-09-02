package at.mschneider.appium.utils;

import org.openqa.selenium.By;

/**
 * Convenience methods for element selection
 * 
 * TODO: extend {@link org.openqa.selenium.By} instead
 */
public class SelectorHelper
{

    /**
     * @param resourceId the resource-id of the element to select
     * @param text the text-attribute of the element to select
     * @return {@link By} selector
     */
    public static By byIdAndText(String resourceId, String text)
    {
        return By.xpath("//*[@resource-id=\"" + resourceId + "\" and @text=\"" + text + "\"]");
    }
}
