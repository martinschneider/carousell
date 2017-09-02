package at.mschneider.appium.components;

import static at.mschneider.appium.utils.SelectorHelper.byIdAndText;
import static com.codeborne.selenide.Selenide.$;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import at.mschneider.appium.utils.PageFactory;

/**
 * Page object for the login with email page
 */
public class LoginWithEmailPage extends AbstractPage
{

    private static final String LOGIN_BUTTON = "com.thecarousell.Carousell:id/action_signin";
    private static final String PASSWORD_FIELD = "com.thecarousell.Carousell:id/text_password";
    private static final String USERNAME_FIELD = "com.thecarousell.Carousell:id/text_username";
    private static final String SIGNUP_LOGIN_SWITCH = "com.thecarousell.Carousell:id/text_tab";
    private static final String LOGIN_LABEL = "LOGIN";

    /**
     * Ensure the "Login"-tab is active
     * 
     * @return {@link LoginWithEmailPage}
     */
    public LoginWithEmailPage switchToLogin()
    {
        $(byIdAndText(SIGNUP_LOGIN_SWITCH, LOGIN_LABEL)).click();
        return this;
    }

    /**
     * Logs the user in with username and password.
     * 
     * @param username username for login
     * @param password password for login
     * @return {@link DashboardPage}
     */
    public DashboardPage login(String username, String password)
    {
        $(By.id(USERNAME_FIELD)).sendKeys(username);
        $(By.id(PASSWORD_FIELD)).sendKeys(password);
        $(By.id(LOGIN_BUTTON)).click();
        sleep(TimeUnit.SECONDS, 2); // after the login the app might jump to the
                                    // "Activity"-tab. Wait for that before any
                                    // other action.
        return PageFactory.dashboardPage();
    }
}
