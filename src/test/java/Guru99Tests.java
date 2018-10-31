import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;

public class Guru99Tests {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIfUserCanLogIn() throws Exception {
        String baseUrl = "http://demo.guru99.com/v4";
        String actualName = "";
        String expectedName = "Guru99 Bank";

        driver.get(baseUrl);

        driver.findElement(By.name("uid")).sendKeys("mgr123");
        driver.findElement(By.name("password")).sendKeys("mgr!23");
        driver.findElement(By.name("btnLogin")).submit();
        Thread.sleep(4000);
        actualName = driver.findElement(By.className("barone")).getText();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    public void CheckSuccessfullyLoggedIn() throws Exception {
        String baseUrl = "http://demo.guru99.com/test/login.html";
        String realName = "";
        String expectedName = "Successfully Logged in...";
        driver.get(baseUrl);

        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("abc");
        Thread.sleep(3000);
        driver.findElement(By.name("SubmitLogin")).click();
        Thread.sleep(2000);
        realName = driver.findElement(By.className("error-copy")).getText();
        assertThat(realName).isEqualTo(expectedName);


    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
