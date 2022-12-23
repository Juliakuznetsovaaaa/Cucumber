package Steps;

import Pages.LoginPage;
import Pages.MusicSearchPage;
import Pages.ProfilePage;
import Pages.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotionSteps {
    public WebDriver driver;
    public LoginPage loginPage;
    public WaitHelper waitHelper;
    public ProfilePage profilePage;
    private static final String BASE_URL = "https://ok.ru/";

    @Дано("Пользователь на домашней странице")
    public void пользователь_на_домашней_странице() {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        profilePage=new ProfilePage(driver);
        waitHelper=new WaitHelper(driver);
        loginPage.inputLogin("technoPol11");
        loginPage.inputPasswd("technoPolis2022");
        loginPage.clickLoginBtn();

    }
    @Когда("Пользователь нажимает на кнопку заметки")
    public void пользователь_нажимает_на_кнопку_заметки() {
        profilePage.notionBtmClick();
    }

    @И("Пользователь вводит заметку {string}")
    public void пользователь_вводит_заметку(String notion) {
        profilePage.sendNotinoText(notion);
    }

    @И("Пользователь публикует заметку")
    public void пользователь_публикует_заметку() {
        profilePage.clickPushBtm();
    }

    @Тогда("Публикация должна быть {string}")
    public void публикация_должна_быть(String gotNotion){
        String notion = profilePage.getText();
        Assert.assertEquals(notion, gotNotion);
        profilePage.deleteNotion();
        loginPage.driverClose();
    }
}
