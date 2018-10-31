import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleTests {
    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void checkInfo() throws Exception {
        String baseUrl = "https://www.google.com/";
        String getAddress = "";
        String getTelefon = "";
        String getOpinions = "";

        driver.get(baseUrl);


        driver.findElement(By.name("q")).sendKeys("Intel Gdańsk");

        Thread.sleep(1000);

        driver.findElement(By.className("lsb")).click();

        Thread.sleep(2000);

        getAddress = driver.findElement(By.cssSelector("#rhs_block > div > div.kp-blk.knowledge-panel.Wnoohf.OJXvsb > div > div.ifM9O > div:nth-child(2) > div.SALvLe.farUxc.mJ2Mod > div > div:nth-child(2) > div > div > span.LrzXr")).getText();
        System.out.println(getAddress);

        getTelefon = driver.findElement(By.cssSelector("#rhs_block > div > div.kp-blk.knowledge-panel.Wnoohf.OJXvsb > div > div.ifM9O > div:nth-child(2) > div.SALvLe.farUxc.mJ2Mod > div > div:nth-child(4) > div > div > span.LrzXr.zdqRlf.kno-fv > span > span")).getText();
        System.out.println(getTelefon);

        getOpinions = driver.findElement(By.cssSelector("#rhs_block > div > div.kp-blk.knowledge-panel.Wnoohf.OJXvsb > div > div.ifM9O > div:nth-child(2) > div:nth-child(8) > div:nth-child(2) > div.RkBmNb > span > span > a > span")).getText();
        System.out.println(getOpinions);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
