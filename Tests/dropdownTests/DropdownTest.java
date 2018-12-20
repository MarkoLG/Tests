package Tests.dropdownTests;

import Pages.DropdownPage;
import Pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Utilities.TestUtilities;

public class DropdownTest extends TestUtilities {
    @Test
    public void optionTwoTest() {
    log.info("Starting optionTwoTest");
    WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
    welcomePage.openPage();
    DropdownPage dropDownPage = welcomePage.clickDropdownLink();
    dropDownPage.selectOption(2);
    String selectedOption = dropDownPage.getSelectedOption();
    Assert.assertTrue(selectedOption.equals("Option 2"), "Option 2 is not selected. Insted selected - " + selectedOption);
}
}