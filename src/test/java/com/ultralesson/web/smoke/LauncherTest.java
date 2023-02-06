package com.ultralesson.web.smoke;

//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LauncherTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void  setup() {
        // Launch web application https://web-playground.ultralesson.com/ on chrome
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("drivers/chromedriver").getPath());
        driver = new ChromeDriver();
        driver.get("https://web-playground.ultralesson.com/");
    }

    @Test
    public void launcherTest() {
        // Get locator of search icon
        WebElement searchIcon = driver.findElement(By.cssSelector("summary[aria-label='Search']"));

        // Verify if search icon is enabled
        boolean displayed = searchIcon.isDisplayed();

        Assert.assertTrue(displayed);
    }

    // Setup

    // Action / Test

    // Tear down

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
