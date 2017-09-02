package at.mschneider.appium.components;

import static at.mschneider.appium.utils.SelectorHelper.byIdAndText;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import at.mschneider.appium.utils.PageFactory;

/**
 * Page object for the dashboard page
 */
public class DashboardPage extends AbstractPage
{
    private static final String CATEGORY_CONTAINER = "com.thecarousell.Carousell:id/list_collection";
    private static final String MENU_LINK = "com.thecarousell.Carousell:id/text_tab";
    private static final String USERNAME_LABEL = "com.thecarousell.Carousell:id/text_username";

    /**
     * @param categoryName the name of the category to open
     * @return {@link CategoryPage}
     */
    public CategoryPage openCategory(String categoryName)
    {
        $(byIdAndText(MENU_LINK, "BROWSE")).click();
        scrollIntoView(CATEGORY_CONTAINER, "CARS").click();
        return PageFactory.categoryPage();
    }

    /**
     * Verify that the user has been successfully logged in
     * 
     * @param username username to check for
     */
    public String getLoggedInUser()
    {
        $(byIdAndText(MENU_LINK, "ME")).click();
        return $(By.id(USERNAME_LABEL)).getText();
    }
}
