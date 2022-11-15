package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "chrome";
    static String baseURL = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver", "drivers/firefox.exe");
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println(" Wrong Browser Name ");
        }

        //launch the URL in browser
        driver.get(baseURL);
        //maximize the browser's window
        driver.manage().window().maximize();
        //give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        //Print the title of the page
        System.out.println("Page title is : " + driver.getTitle());

        //Print the current URL
        System.out.println("Current URL of page is : " + driver.getCurrentUrl());

        //Print the Page Source
        System.out.println("Page Source : " + driver.getPageSource());

        //Enter the Username to Username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");


        //Enter the Password to Password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        //Close the browser
        driver.close();
    }
}
