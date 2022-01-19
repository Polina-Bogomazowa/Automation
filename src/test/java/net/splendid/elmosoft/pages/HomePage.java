package net.splendid.elmosoft.pages;

import java.util.List;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class HomePage extends Page {

    @FindBy(xpath="//button[contains(text(), 'Open Menu')]")
    private BrowserElement sandwichMenu;

    @FindBy(xpath="//button[contains(text(), 'Add to cart')]")
    private List <BrowserElement> addToCartBtns;


    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
    private BrowserElement cartIcon;



    public HomePage clickByAddBtn(int index){
        addToCartBtns.get(index).click();
        return PageFactory.initElements(driver, HomePage.class);
    }
    public YourCartPage clickByCartIcon(){
        cartIcon.click();
        return PageFactory.initElements(driver, YourCartPage.class );
    }


    public Boolean isHomePageOpened(){
        return sandwichMenu.isExists();
    }

    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {
          }




}
