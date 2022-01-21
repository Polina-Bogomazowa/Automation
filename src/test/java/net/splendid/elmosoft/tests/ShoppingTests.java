package net.splendid.elmosoft.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.*;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners({ SuiteListener.class, HTMLReporter.class })
@Epic("Demo Tests")
@Feature("REX Tab")
@Guice
public class ShoppingTests extends BaseSplendidTest {
    @Test
    public void verifyAddingToCart(){
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user","secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");
        HomePage homepage = new HomePage();
        homepage.clickByAddBtn(0);
        Boolean resultChoosen = homepage.clickByCartIcon().isProductChoosen();
        Assert.assertTrue(resultChoosen, "Product Sauce Labs Backpack wasn't added to cart");

        YourCartPage yourCartPage = new YourCartPage();
        yourCartPage.clickByRemoveBtn();

        Assert.assertFalse(yourCartPage.isCartItemLabelExist(), "Product Sauce Labs Backpack was added to cart");
    }

    @Test
    public void verifyCheckOut(){
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user","secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");

        HomePage homepage = new HomePage();
        homepage.clickByAddBtn(0);
        Boolean resultChoosen = homepage.clickByCartIcon().isProductChoosen();
        Assert.assertTrue(resultChoosen, "Product Sauce Labs Backpack wasn't added to cart");

        YourCartPage yourCart = new YourCartPage();
        yourCart.clickByCheckOut();

        YourInformationPage yourInfa = new YourInformationPage();

        yourInfa.doInformation("Polina","Bogomazova","12300");
        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
        checkOutOverviewPage.doClickOnFinish();

        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();

        Boolean resultCheck = checkOutCompletePage.isCheckOutCompletePageOpened();
        Assert.assertTrue(resultCheck, "Error,u didn't checked out");





    }

}
