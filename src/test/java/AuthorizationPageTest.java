import helpers.Constant;
import helpers.UserClient;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AuthorizationPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.junit.Assert.assertEquals;

public class AuthorizationPageTest {
    WebDriver driver;
    AuthorizationPage authorizationPage;
    MainPage mainPage;
    String accessToken;
    UserClient userClient;
    String email;
    String password;
    String name;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getWebDriver();
        driver.get(Constant.LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        authorizationPage = new AuthorizationPage(driver);
        userClient = new UserClient();
        mainPage = new MainPage(driver);
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        name = faker.name().username();
        accessToken = userClient.createUser(email, password, name).extract().body().path("accessToken");

    }

    @After
    public void closeWithDelete() {
        driver.quit();
        if (accessToken != null) {
            userClient.deleteUser(accessToken)
                    .assertThat().statusCode(SC_ACCEPTED);
        }
    }

    @Test
    @DisplayName("Проверка авторизации по кнопке Войти в аккаунт")
    public void checkAuthorizationFromEnterAccountButtonTest() {
        authorizationPage.clickLogo();
        mainPage.clickEnterAccountButton();
        authorizationPage.userLogin(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(Constant.MAIN_PAGE_URL));
        assertEquals(Constant.MAIN_PAGE_URL, mainPage.getLink());
    }

    @Test
    @DisplayName("Проверка авторизации по гиперссылке Войти(на странице регистрации)")
    public void checkAuthorizationFromRegistrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        authorizationPage.clickRegistrationHref();
        registrationPage.clickEnterButton();
        authorizationPage.userLogin(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(Constant.MAIN_PAGE_URL));
        assertEquals(Constant.MAIN_PAGE_URL, mainPage.getLink());
    }

    @Test
    @DisplayName("Проверка авторизации по гиперссылке Войти(на странице восстановления пароля)")
    public void checkAuthorizationFromTheRecoveryPageTest() {
        authorizationPage.clickRecoverPasswordHref();
        authorizationPage.clickEnterHref();
        authorizationPage.userLogin(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(Constant.MAIN_PAGE_URL));
        assertEquals(Constant.MAIN_PAGE_URL, mainPage.getLink());
    }

    @Test
    @DisplayName("Проверка авторизации по кнопке Личный кабинет")
    public void checkAuthorizationFromPersonalAreaButtonTest() {
        authorizationPage.clickLogo();
        mainPage.clickPersonalAreaButton();
        authorizationPage.userLogin(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(Constant.MAIN_PAGE_URL));
        assertEquals(Constant.MAIN_PAGE_URL, mainPage.getLink());
    }

}
