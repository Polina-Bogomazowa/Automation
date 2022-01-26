package net.splendid.elmosoft.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.driver.element.BrowserElement;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.HomePage;
import net.splendid.elmosoft.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import java.util.ArrayList;
import java.util.List;

@Listeners({SuiteListener.class, HTMLReporter.class})
@Epic("Smoke test")
@Feature("LogIn")
@Guice
public class AuthorizationTest extends BaseSplendidTest {
    @Test()
    public void verifyValidCread() {
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user", "secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");
    }

    @Test
    public void verifyLocked() {
        LogInPage logiiin = new LogInPage();
        logiiin.openPage();
        logiiin.doLockedLogin("locked_out_user", "secret_sauce ");
        Boolean resultLocked = logiiin.isErrorMessageExist();
        Assert.assertTrue(resultLocked, "UNLOCKED USER!");
    }

    @Test
    public void verifyProblemUser() {
        LogInPage logiiin = new LogInPage();
        logiiin.openPage();
        logiiin.doLogin("problem_user", "secret_sauce");
        HomePage homePage = new HomePage();
        homePage.isHomePageOpened();

        ArrayList <String> expectedResult = new ArrayList <String>();
        for(int i=0; i<6;i++){
            expectedResult.add("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg");
        }

        List<String> actualResults = homePage.getListOfPathImgs();
        //List<WebElement> samePictures = driver.findElements(By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']"));
        Assert.assertEquals(actualResults, expectedResult, "Imgs are not the same");

    }


}
