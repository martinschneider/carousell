package at.mschneider.appium.utils;

import at.mschneider.appium.components.CategoryPage;
import at.mschneider.appium.components.ConfirmationDialog;
import at.mschneider.appium.components.DashboardPage;
import at.mschneider.appium.components.ItemPage;
import at.mschneider.appium.components.LoginPage;
import at.mschneider.appium.components.LoginWithEmailPage;
import at.mschneider.appium.components.OfferPage;

/**
 * Page factory
 * 
 * TODO: In a "real" project there should be a more generic implementation of this class
 */
public class PageFactory
{

    private static DashboardPage dashboardPage;
    private static ItemPage itemPage;
    private static LoginPage loginPage;
    private static LoginWithEmailPage loginWithEmailPage;
    private static OfferPage offerPage;
    private static CategoryPage categoryPage;
    private static ConfirmationDialog confirmationDialog;

    public static DashboardPage dashboardPage()
    {
        if (dashboardPage == null)
            dashboardPage = new DashboardPage();
        return dashboardPage;
    }

    public static ItemPage itemPage()
    {
        if (itemPage == null)
            itemPage = new ItemPage();
        return itemPage;
    }

    public static LoginPage loginPage()
    {
        if (loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }

    public static LoginWithEmailPage loginWithEmailPage()
    {
        if (loginWithEmailPage == null)
            loginWithEmailPage = new LoginWithEmailPage();
        return loginWithEmailPage;
    }

    public static OfferPage offerPage()
    {
        if (offerPage == null)
            offerPage = new OfferPage();
        return offerPage;
    }

    public static CategoryPage categoryPage()
    {
        if (categoryPage == null)
            categoryPage = new CategoryPage();
        return categoryPage;
    }

    public static ConfirmationDialog confirmationDialog()
    {
        if (confirmationDialog == null)
            confirmationDialog = new ConfirmationDialog();
        return confirmationDialog;
    }
}
