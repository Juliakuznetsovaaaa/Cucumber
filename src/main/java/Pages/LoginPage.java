package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    public  WebDriver driver;
    public WaitHelper waitHelper;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        waitHelper=new WaitHelper(driver);
    }
    @FindBy(xpath = "//*[contains(@id,'field_email')]")
    WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'field_password')]")
    WebElement passwordField;

    @FindBy(xpath = "//*[contains(@value, 'Войти в Одноклассники')]")
    WebElement loginBtn;

    public void inputLogin(String login) {
        waitHelper.WaitForElement(loginField,30);
        loginField.sendKeys(login);
    }

    public void inputPasswd(String password) {
        waitHelper.WaitForElement(passwordField,30);
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn() {
        waitHelper.WaitForElement(loginBtn,30);
        loginBtn.click();
    }
    public void driverClose(){
        driver.close();
    }
}