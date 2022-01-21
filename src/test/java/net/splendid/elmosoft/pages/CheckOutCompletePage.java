package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;

public class CheckOutCompletePage extends Page {

    @FindBy(xpath = "//img[@src='/static/media/pony-express.46394a5d.png']")
    private BrowserElement finishPicture;

    public Boolean isCheckOutCompletePageOpened() {
        return finishPicture.isExists();
    }
    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {

    }
}
