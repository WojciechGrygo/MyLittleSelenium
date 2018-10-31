import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MercuryToursTests {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void Register() throws Exception {
        String baseUrl = "http://newtours.demoaut.com/";
        String actualText = "";
        String expectedText = "Note: Your user name is Gryzio69.";

        driver.get(baseUrl);

        driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > a")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("firstName")).sendKeys("Wojtuś");
        driver.findElement(By.name("lastName")).sendKeys("Gryzio");
        driver.findElement(By.name("phone")).sendKeys("0700123123");
        driver.findElement(By.name("firstName")).sendKeys("Wojtuś");
        driver.findElement(By.id("userName")).sendKeys("gryzio@xddd.pl");
        driver.findElement(By.id("email")).sendKeys("Gryzio69");
        driver.findElement(By.name("password")).sendKeys("seksi69");
        driver.findElement(By.name("confirmPassword")).sendKeys("seksi69");

        driver.findElement(By.name("register")).click();

        Thread.sleep(2000);

        actualText = driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > a > font > b")).getText();
        assertThat(actualText).isEqualTo(expectedText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

