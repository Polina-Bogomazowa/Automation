package net.splendid.elmosoft.pages;
import net.splendid.elmosoft.pages.SwagLabsConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private static WebDriverWait wait;

    @FindBy (how = How.ID, id = "user-name")
    private static WebElement login;

    @FindBy (how = How.ID, id = "password")
    private static WebElement password;

    @FindBy (how = How.ID, id = "login-button")
    private static WebElement buttonSubmit;


    @FindBy (how = How.XPATH, xpath = "//*[contains(text(),'Products')]")
    private static WebElement productLabel;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    public void login (){
        wait.until(ExpectedConditions.visibilityOf(login)).sendKeys(SwagLabsConstants.LOGIN_USER);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(SwagLabsConstants.PASSWORD_USER);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit)).click();

    }

    public static String setLoginForTest() {
        wait.until(ExpectedConditions.visibilityOf(login)).sendKeys(SwagLabsConstants.LOGIN_USER);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(SwagLabsConstants.PASSWORD_USER);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit)).click();
        return wait.until(ExpectedConditions.visibilityOf(productLabel)).getText();

    }
}
