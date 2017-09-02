package at.mschneider.appium.components;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import at.mschneider.appium.utils.PageFactory;

/**
 * Page object for the login page
 */
public class LoginPage extends AbstractPage
{
    private static final String EMAIL_SIGNIN_BUTTON = "com.thecarousell.Carousell:id/email_signin_button";

    /**
     * Select email login
     * 
     * @return {@link LoginWithEmailPage}
     */
    public LoginWithEmailPage loginUsingEmail()
    {
        $(By.id(EMAIL_SIGNIN_BUTTON)).click();
        return PageFactory.loginWithEmailPage();
    }
}