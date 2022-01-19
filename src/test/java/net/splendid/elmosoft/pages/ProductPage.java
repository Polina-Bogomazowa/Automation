package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class ProductPage extends Page {

    @FindBy(id = "back-to-products")
    private BrowserElement backToProductsBtn;

    public Boolean isbackToProductsBtnExist() {
        return backToProductsBtn.isExists();
    }

    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {

    }
}
