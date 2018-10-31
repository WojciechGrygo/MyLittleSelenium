import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;

public class PracujPlTests {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIfPracujPlTitleIsCorrect() {
        String actualTitle = "";
        String expectedTitle = "Oferty pracy - Pracuj.pl";
        String baseUrl = "https://www.pracuj.pl";

        driver.get(baseUrl);

        actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @Test
    public void CheckHowManyOffersAreAvailable() throws Exception {
        String baseUrl = "https://www.pracuj.pl";
        String amountOffers = "";

        driver.get(baseUrl);

        driver.findElement(By.name("kw")).sendKeys("tester oprogramowania");
        driver.findElement(By.name("wp")).sendKeys("pomorskie");
        Thread.sleep(1000);
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(3000);
        amountOffers = driver.findElement(By.className("o__search_results_title_number")).getText();
        System.out.println(amountOffers);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
