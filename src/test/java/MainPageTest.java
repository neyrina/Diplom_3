import helpers.Constant;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageTest {
    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getWebDriver();
        mainPage = new MainPage(driver);
        driver.get(Constant.MAIN_PAGE_URL);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка переключения раздела Булки")
    public void checkBunsTabIsDisplayedTest() {
        mainPage.clickSaucesSwitch();
        mainPage.clickBunsSwitch();
        assertTrue(mainPage.bunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Проверка переключения раздела Соусы")
    public void checkSaucesTabIsDisplayedTest() {
        mainPage.clickSaucesSwitch();
        assertTrue(mainPage.saucesHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Проверка переключения раздела Начинки")
    public void checkFillingsTabIsDisplayedTest() {
        mainPage.clickFillingsSwitch();
        assertTrue(mainPage.fillingsHeaderIsDisplayed());
    }

}