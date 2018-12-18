package Tests;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import Pages.WelcomePageObject;
import Utilities.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {
    @Test
    public void logInTest() {
        log.info("Starting logIn test");
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible");
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}
