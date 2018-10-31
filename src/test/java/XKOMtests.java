import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class XKOMtests {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void checkPrice() throws Exception {
        String baseUrl = "https://www.x-kom.pl/";
        String getPrice = "";
        String expectedPrice = "59,00 zł";

        driver.get(baseUrl);


        driver.findElement(By.name("q")).sendKeys("ASUS WT465");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#searchBar > div.search-bar > div.search-button > button > i")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#productList > div:nth-child(2) > button > i")).click();

        Thread.sleep(2000);

        getPrice = driver.findElement(By.cssSelector("#basketItems > div > div > div.price-wrapper > span")).getText();
        assertThat(getPrice).isEqualTo(expectedPrice);


    }

    @Test
    public void checkIssue() throws Exception {
        String baseUrl = "https://www.x-kom.pl/";
        String getAddress = "";
        String actualText = "";
        String expectedText = "Podaj prawidłowy adres e-mail.";

        driver.get(baseUrl);

        Thread.sleep(10000);

        driver.findElement(By.linkText("Kontakt i salony")).click();
        driver.findElement(By.cssSelector("#footerNavigation > div:nth-child(5) > section > ul > li:nth-child(2) > a")).click();

        Thread.sleep(2000);

        getAddress = driver.findElement(By.cssSelector("#basketItems > div > div > div.price-wrapper > span")).getText();
        System.out.println(getAddress);

        driver.findElement(By.name("emailAddress")).sendKeys("sialala");

        driver.findElement(By.cssSelector("#question")).sendKeys("dupadupadupa");

        actualText = driver.findElement(By.cssSelector("#emailAddress-error")).getText();
        assertThat(actualText).isEqualTo(expectedText);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
