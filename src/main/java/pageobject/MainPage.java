package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final By personalAreaButton = By.xpath("//a[contains(@href,'/account')]");
    private final By enterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By bunsSwitch = By.xpath("//span[text()='Булки']");
    private final By saucesSwitch = By.xpath("//span[text()='Соусы']");
    private final By fillingsSwitch = By.xpath("//span[text()='Начинки']");
    private final By bunsIsSelected = By.xpath(".//span[text()='Булки']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");
    private final By saucesIsSelected = By.xpath(".//span[text()='Соусы']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");
    private final By fillingsIsSelected = By.xpath(".//span[text()='Начинки']/parent::div[contains(@class,'tab_tab_type_current__2BEPc')]");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getLink() {
        return driver.getCurrentUrl();
    }
    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    public void clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
    }

    public void clickBunsSwitch() {
        driver.findElement(bunsSwitch).click();
    }

    public void clickSaucesSwitch() {
        driver.findElement(saucesSwitch).click();
    }

    public void clickFillingsSwitch() {
        driver.findElement(fillingsSwitch).click();
    }

    public boolean bunsHeaderIsDisplayed() {
        return driver.findElement(bunsIsSelected).isDisplayed();
    }
    public boolean saucesHeaderIsDisplayed() {
        return driver.findElement(saucesIsSelected).isDisplayed();
    }
    public boolean fillingsHeaderIsDisplayed() {
        return driver.findElement(fillingsIsSelected).isDisplayed();
    }
}

