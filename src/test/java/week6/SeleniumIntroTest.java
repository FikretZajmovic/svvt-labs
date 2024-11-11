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

public class SeleniumIntroTest {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Fikret/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ibu.edu.ba";
    }

    @AfterAll
    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testTitle() throws InterruptedException {
        webDriver.get(baseUrl);
        String actualTitle = webDriver.getTitle();
        System.out.println("Actual title: " + actualTitle);
        assertEquals("International Burch University | IBU", actualTitle, "Title does not match");
        Thread.sleep(1000);
    }

    @Test
    public void testPageTitle() throws InterruptedException {
        webDriver.get(baseUrl + "/department-of-information-technologies");
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        assertEquals("Department of Information Technology | IBU", title);
        Thread.sleep(1000);
    }

    @Test
    public void testContainsNext() {
        webDriver.get(baseUrl + "/department-of-information-technologies");
        String pageSource = webDriver.getPageSource();
        assertTrue(pageSource.contains("_next"));
    }

    @Test
    public void testLearnMoreAboutUs() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.navigate().to(baseUrl + "/about");
        Thread.sleep(2000);
        String title = webDriver.getTitle();
        Thread.sleep(2000);
        webDriver.navigate().back();
        String currentUrl = webDriver.getCurrentUrl();

        assertEquals("About | IBU", title);
        assertEquals("https://www.ibu.edu.ba/", currentUrl);
    }

    @Test
    void testRedirect() throws InterruptedException {
        webDriver.get("https://lms.ibu.edu.ba/");
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assertEquals("https://learning.ibu.edu.ba/", currentUrl);
    }

    @Test
    public void testIBUNavigation() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(3000);
        webDriver.navigate().to(baseUrl + "/student-area");
        Thread.sleep(3000);
        webDriver.navigate().back();
        String url = webDriver.getCurrentUrl();
        assertEquals("https://www.ibu.edu.ba/", url);
        Thread.sleep(3000);
    }

    @Test
    public void testContactForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/contact-us");
        webDriver.manage().window().maximize();


        Thread.sleep(3000);
        WebElement name = webDriver.findElement(By.name("fullName"));
        name.sendKeys("Jane Doe");


        WebElement email = webDriver.findElement(By.name("email"));
        email.sendKeys("jane.doe@ibu.edu.ba");


        WebElement subject = webDriver.findElement(By.name("subject"));
        subject.sendKeys("Hello from SVVT. :)");


        WebElement message = webDriver.findElement(By.name("message"));
        message.sendKeys("Hi, this is an automated test.");
        Thread.sleep(3000);
    }
}
