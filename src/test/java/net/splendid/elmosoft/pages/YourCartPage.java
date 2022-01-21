package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class YourCartPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Sauce Labs Backpack')]")
    private BrowserElement product;

    @FindBy(id="remove-sauce-labs-backpack")
    private BrowserElement removeCartBtn;


    @FindBy(xpath = "//div[@class='cart_item_label']")
    private BrowserElement cartItemLabel;

    @FindBy(id="checkout")
    private BrowserElement checkOutBtn;

    public YourCartPage clickByRemoveBtn(){
        removeCartBtn.click();
        return PageFactory.initElements(driver, YourCartPage.class );
    }

    public Boolean isProductChoosen(){
        return product.isExists();
    }

    public Boolean isCartItemLabelExist(){
        return cartItemLabel.isExists();
}

    public YourCartPage clickByCheckOut() {
        checkOutBtn.click();
        return PageFactory.initElements(driver, YourCartPage.class);
    }
    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {

    }
}
