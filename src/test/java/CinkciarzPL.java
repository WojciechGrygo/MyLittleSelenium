import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CinkciarzPL {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkIfCourseIsCorrect() throws Exception {
        String baseUrl = "http://www.cinkciarz.pl";

        driver.get(baseUrl);

        driver.findElement(By.name("amount-in")).sendKeys("1000");

        driver.findElement(By.cssSelector("#calculator > form > div:nth-child(3) > div > button.btn.btn-style-03.btn-light-outline.ml-16.d-none.d-lg-inline-block")).click();

        Thread.sleep(5000);

        assertThat(driver.findElement(By.id("amount-out"))
                .getAttribute("value")).contains("23");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
