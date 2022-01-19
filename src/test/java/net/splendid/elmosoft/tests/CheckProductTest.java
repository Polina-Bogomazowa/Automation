package net.splendid.elmosoft.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.driver.page.Page;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.LogInPage;
import net.splendid.elmosoft.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners({SuiteListener.class, HTMLReporter.class})
@Epic("Smoke test")
@Feature("LogIn")
@Guice

public class CheckProductTest extends BaseSplendidTest {

    @Test
    public void verifyCheckProduct(){
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user", "secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");

        /*ProductPage productpage = new ProductPage();
        Boolean resultcheck = productpage.isbackToProductsBtnExist();
        Assert.assertTrue(resultcheck, "product page is not opened");*/
    }


}
