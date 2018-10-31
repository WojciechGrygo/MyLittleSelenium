import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CodementorsTest {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void checkInfo() throws Exception {
        String baseUrl = "https://codementors.pl/";
        String getAddress = "";
        String getTelefon = "";
        String getEmail = "";

        driver.get(baseUrl);

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#menu > li:nth-child(8) > a")).click();

        Thread.sleep(1000);

        getAddress = driver.findElement(By.className("info")).getText();
        System.out.println(getAddress);

        getTelefon = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > section.contact-area.fix > div > div > div:nth-child(2) > div > div:nth-child(3) > p")).getText();
        System.out.println(getTelefon);

        getEmail = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > section.contact-area.fix > div > div > div:nth-child(2) > div > div:nth-child(2) > p:nth-child(2) > span")).getText();
        System.out.println(getEmail);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
