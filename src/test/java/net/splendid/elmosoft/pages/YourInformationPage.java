package net.splendid.elmosoft.pages;

import net.elmosoft.splendid.driver.annotation.FindBy;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.driver.page.PageFactory;

public class YourInformationPage extends Page {
    @FindBy(id="first-name")
    private BrowserElement firstNameField;

    @FindBy(id="last-name")
    private BrowserElement lastNameField;

    @FindBy(id="postal-code")
    private BrowserElement codeField;

    @FindBy(id="continue")
    private BrowserElement continueBtn;


    public CheckOutOverviewPage doInformation(String first_name, String last_name, String code) {
        firstNameField.type(first_name);
        lastNameField.type(last_name);
        codeField.type(code);
        continueBtn.click();
        return PageFactory.initElements(driver, CheckOutOverviewPage.class);
    }

    @Override
    public void checkPage() {

    }

    @Override
    public void waitForPageIsLoaded() {

    }
}
