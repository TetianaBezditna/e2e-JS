
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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // input user name
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // input the password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        // Click on the button 'Login'
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        // check the title on the page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
        driver.getTitle();
        assertEquals("OrangeHRM",    driver.getTitle(), "title = " +   driver.getTitle());

        //checked URL
        assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",  driver.getCurrentUrl());

    }

}
