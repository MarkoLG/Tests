package Tests.alertTests;

import Pages.AlertsPage;
import Pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Utilities.TestUtilities;

public class AlertTest extends TestUtilities {

    @Test
    public void jsAlertTest(){
    log.info("Starting jsAlertTest");
    WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
    welcomePage.openPage();

        AlertsPage alertsPage = welcomePage.clickJSLink();
        alertsPage.openJSAlert();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText();
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"), "Alert message is not expected. \nShould be 'I am a JS Alert', but is something different");
        Assert.assertTrue(result.equals("You succcessfuly clicked an alert"), "result is not expected. \nShould be 'You successfuly clicked an alert, but is something different");

}
    @Test
    public void jsDismissTest(){
        log.info("Starting jsDismissTest");
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        AlertsPage alertsPage = welcomePage.clickJSLink();
        alertsPage.openJSConfirm();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        String result = alertsPage.getResultText();
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not expected. \nShould be 'I am a JS Alert', but is something different");
        Assert.assertTrue(result.equals("You succcessfuly clicked an alert"), "result is not expected. \nShould be 'You successfuly clicked an alert, but is something different");

    }
}
