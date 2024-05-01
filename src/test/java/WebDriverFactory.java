import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver() {
        String driver = System.getProperty("browser");
        if(driver !=null && driver.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
            return  new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            return  new ChromeDriver();
        }
    }
}

