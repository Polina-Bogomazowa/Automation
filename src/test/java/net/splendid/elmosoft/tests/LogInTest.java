package net.splendid.elmosoft.tests;

import com.google.inject.Inject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import net.elmosoft.splendid.service.runner.SuiteListener;
import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.LoginPage;
import net.splendid.elmosoft.pages.SwagLabsConstants;
import net.splendid.elmosoft.steps.GoogleSteps;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;
@Listeners({ SuiteListener.class, HTMLReporter.class })
@Epic("Demo Tests")
@Feature("REX Tab")
@Guice
public class LogInTest extends BaseSplendidTest {

    @Inject

    @Test()
            public void verifyLogIn(){
        LoginPage loginPage = new LoginPage(driver);
        String productsLabel = LoginPage.setLoginForTest();
        Assert.assertEquals(productsLabel, SwagLabsConstants.PRODUCTS_GALLERY);
    }


}
