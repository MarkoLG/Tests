package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    public driverFactory(String browser){
        this.browser = browser.toLowerCase();
    }
    public WebDriver createDriver() {
        System.out.println("Create driver: " + browser);
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\rb26599\\Downloads\\drivery\\chromedriver.exe");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\rb26599\\Downloads\\drivery\\geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\rb26599\\Downloads\\drivery\\chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }
        return  driver.get();
    }
}
