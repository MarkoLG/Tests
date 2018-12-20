package Tests;

import Pages.LoginPage;
import Pages.WelcomePageObject;
import Utilities.TestUtilities;
import org.openqa.selenium.By;
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
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");

        // push log in button
        driver.findElement(By.className("radius")).click();

        // Verification
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }

}
