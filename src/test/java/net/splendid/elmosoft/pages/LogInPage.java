package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class LogInPage extends Page {
    @FindBy(id="user-name")
    private BrowserElement logInField;

    @FindBy(id="password")
    private BrowserElement passwordField;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private BrowserElement errorMessage;

    @FindBy(id="login-button")
    private BrowserElement loginBtn;

    public HomePage doLogin(String user_name, String password){
        logInField.type(user_name);
        passwordField.type(password);
        loginBtn.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public LogInPage doLockedLogin(String user_name, String password){
        logInField.type(user_name);
        passwordField.type(password);
        loginBtn.click();
        return PageFactory.initElements(driver, LogInPage.class);
    }

    public LogInPage openPage() {
        driver.get("https://www.saucedemo.com");
        return PageFactory.initElements(driver, LogInPage.class);
    }


    public Boolean isErrorMessageExist(){
        return errorMessage.isExists();
    }






    @Override
    public void checkPage() {
        waitForPageIsLoaded();
        loginBtn.waitForElementDisplayed(TEN_SECONDS_WAIT);

    }

    @Override
    public void waitForPageIsLoaded() {
        driver.waitForPageLoad();

    }
}
