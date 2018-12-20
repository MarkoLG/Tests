package Tests.checkBoxesTest;

import Pages.WelcomePageObject;
import resources.Utilities.TestUtilities;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectringTwoCheckboxesTest() {
            WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
            welcomePage.openPage();

    }
}
