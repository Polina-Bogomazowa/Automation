package net.splendid.elmosoft.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.HomePage;
import net.splendid.elmosoft.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

@Listeners({SuiteListener.class, HTMLReporter.class})
@Epic("Demo Tests")
@Feature("REX Tab")
@Guice
public class LogOutTest extends BaseSplendidTest {
    @Test
    public void verifyLoggingOut() {
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user", "secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");

        HomePage homepage = new HomePage();
        homepage.clickOnLogOut();
        Boolean resultLoggingout=homepage.isReturnedToLogInPage();
        Assert.assertTrue(resultLoggingout, "UNLOCKED USER!");

    }


}
