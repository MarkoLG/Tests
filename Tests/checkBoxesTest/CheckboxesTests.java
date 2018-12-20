package Tests.checkBoxesTest;

import Pages.CheckboxesPage;
import Pages.WelcomePageObject;
import org.testng.Assert;
import resources.Utilities.TestUtilities;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectringTwoCheckboxesTest() {
            WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
            welcomePage.openPage();
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        checkboxesPage.selectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are selected");
    }
}
