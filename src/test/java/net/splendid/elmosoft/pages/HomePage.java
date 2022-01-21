package net.splendid.elmosoft.pages;

import java.util.List;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

    @FindBy(xpath = "//button[contains(text(), 'Open Menu')]")
    private BrowserElement sandwichMenu;

    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
    private List<BrowserElement> addToCartBtns;

    @FindBy(id="login-button")
    private BrowserElement loginBtn;

    @FindBy(id = "logout_sidebar_link")
    private BrowserElement logOutBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
    private BrowserElement cartIcon;

    @FindBy(xpath = "//img[@src='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']")
    private BrowserElement clickByProduct;

    //@FindBy(xpath ="//img[@src='/static/media/sl-404.168b1cce.jpg']")
    //private BrowserElement FirstPicture;

    @FindBy(xpath = "//img[@src='/static/media/sl-404.168b1cce.jpg']")
    private List<WebElement> samePictures;



    public Boolean isReturnedToLogInPage(){
        return loginBtn.isExists();
    }

    public HomePage clickByAddBtn(int index) {
        addToCartBtns.get(index).click();

        return PageFactory.initElements(driver, HomePage.class);

    }

    public YourCartPage clickByCartIcon() {
        cartIcon.click();
        return PageFactory.initElements(driver, YourCartPage.class);
    }



    public ProductPage clickOnProductImage() {
        clickByProduct.click();
        return PageFactory.initElements(driver, ProductPage.class);
    }

    public Boolean isHomePageOpened() {
        return sandwichMenu.isExists();
    }

    public List<WebElement> ifSamePictExist(By by) {

        return (List<WebElement>) driver.findElements(by);
    }

    public LogInPage clickOnLogOut() {
        sandwichMenu.click();
        logOutBtn.click();
        return PageFactory.initElements(driver, LogInPage.class);
    }



    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {
    }


}
