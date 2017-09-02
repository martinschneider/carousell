package at.mschneider.appium.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import at.mschneider.appium.components.DashboardPage;
import at.mschneider.appium.components.LoginPage;
import at.mschneider.appium.components.OfferPage;

/**
 * Offer test
 */
public class OfferTest extends AppiumTest
{
    /**
     * Make an offer
     * 
     * <ol>
     * <li>Login via email</li>
     * <li>Verify user is logged in</li>
     * <li>Go to "Cars" section</li>
     * <li>Select first item</li>
     * <li>Make an offer</li>
     * </ol>
     */
    @Test
    public void makeAnOffer()
    {
        String username = System.getProperty("username", "martinschneider");
        String password = System.getProperty("password", "iwonttellyou");
        BigDecimal offerAmount = new BigDecimal("1.00").setScale(2);

        DashboardPage dashboard = login(username, password);
        assertThat(dashboard.getLoggedInUser()).isEqualTo(username);

        OfferPage offer = dashboard.openCategory("Cars").openFirstItem().makeOffer().amount(offerAmount);
        assertThat(offer.getAmount()).isEqualTo(offerAmount);

        offer.submit().confirm();
        assertThat(offer.hasOfferBeenMade(offerAmount));
    }

    /**
     * @param username username of the user to be logged in
     * @param password password of the user to be logged in
     * @return {@link DashboardPage}
     */
    private DashboardPage login(String username, String password)
    {
        return new LoginPage().loginUsingEmail().switchToLogin().login(username, password);
    }
}