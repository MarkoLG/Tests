package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject {
    private WebDriver driver;
    private Logger log;
    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.log = log;
    }
    public void openPage(){
        log.info("Opening page: " + pageUrl);
        driver.get(pageUrl);
        log.info("Page opened!");
    }
    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication link on Welcome Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }
}
