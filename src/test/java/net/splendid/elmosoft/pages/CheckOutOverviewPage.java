package net.splendid.elmosoft.pages;

import java.util.List;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutOverviewPage extends Page {
    @FindBy(id = "finish")
    private BrowserElement finishBtn;

    public CheckOutCompletePage doClickOnFinish() {
        finishBtn.click();
        return PageFactory.initElements(driver, CheckOutCompletePage.class);
    }

    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {

    }
}
