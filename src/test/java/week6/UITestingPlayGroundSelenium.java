package week6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UITestingPlayGroundSelenium {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Fikret/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "http://www.uitestingplayground.com/sampleapp";
    }

    @AfterAll
    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testForm() {
        webDriver.get(baseUrl);
        WebElement userName = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        assertEquals("input", userName.getTagName());
        assertEquals("input", password.getTagName());

        userName.clear();
        password.clear();

        userName.sendKeys("test");
        password.sendKeys("pwd");

        WebElement loginButton = webDriver.findElement(By.id("login"));

        assertEquals("button", loginButton.getTagName());

        loginButton.click();

        WebElement loginStatus = webDriver.findElement(By.id("loginstatus"));

        assertTrue(loginStatus.getText().contains("test"));

        webDriver.close();
    }
}
