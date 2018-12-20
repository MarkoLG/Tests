package Tests.loginTest;

import Pages.LoginPage;
import Pages.WelcomePageObject;
import resources.Utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.*;


public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        System.out.println("Starting negativeTest");

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

        loginPage.negativeLogIn(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        System.out.println(message);
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");

    }

}
