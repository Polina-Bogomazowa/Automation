package net.splendid.elmosoft.tests;

import com.google.inject.Inject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.LogInPage;
import net.splendid.elmosoft.pages.SwagLabsConstants;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

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



}
