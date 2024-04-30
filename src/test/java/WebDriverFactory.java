import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver() {
        String driver = "chrome";
        switch (driver){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                return  new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
                return  new ChromeDriver();
            default:
                throw new IllegalStateException("Неподдерживаемый браузер");
        }
    }
}

