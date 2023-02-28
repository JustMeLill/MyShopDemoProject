package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void Setup (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void Clear(){
        driver.quit();
        //driver.quit(); = inchide browserul cu oricate tab-uri deschise
        //driver.close(); = inchide doar tab-ul curent
    }




}
