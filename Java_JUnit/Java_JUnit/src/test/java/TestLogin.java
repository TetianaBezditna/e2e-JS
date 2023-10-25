
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


public class TestLogin {
    private static WebDriver driver;
    private String userName = "Admin";
    private String password = "admin123";
    private String userNameField = "//input[@name='username']";
    private String passwordField = "//input[@name='password']";
    private String buttonLogin = "//button[text()=' Login ']";
    private String title = "OrangeHRM";
    private String URL = "https://opensource-demo.orangehrmlive.com/web/index.php";

    @BeforeAll
    public static void initWebDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterAll
    public static void closeWebDriver(){
        driver.close();
        driver.quit();
    }

    @Test
    public void checkLoginInSite (){
        //open the login form
        driver.get(URL + "/auth/login");

        // input user name
        driver.findElement(By.xpath(userNameField)).sendKeys(userName);

        // input the password
        driver.findElement(By.xpath(passwordField)).sendKeys(password);

        // Click on the button 'Login'
        driver.findElement(By.xpath(buttonLogin)).click();

        // check the title on the page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs(title));
        driver.getTitle();
        assertEquals(title,    driver.getTitle(), "title = " +   driver.getTitle());

        //checked URL
        assertEquals(URL + "/dashboard/index",  driver.getCurrentUrl());

    }

}
