package net.splendid.elmosoft.tests;

import net.elmosoft.splendid.test.BaseSplendidTest;
import net.splendid.elmosoft.pages.HomePage;
import net.splendid.elmosoft.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SocialMediaTest extends BaseSplendidTest {

    @Test
    public void verifySocialMedia() {
        LogInPage logiiin = new LogInPage();
        logiiin.openPage().checkPage();
        Boolean resultLogIn = logiiin.doLogin("standard_user", "secret_sauce").isHomePageOpened();
        Assert.assertTrue(resultLogIn, "Home page is not opened");

        HomePage homepage = new HomePage();
        homepage.clickByTwitterIcon();
        String expectedTwitterUrl = "https://twitter.com/saucelabs";
        Assert.assertEquals(homepage.getTwUrl(2), expectedTwitterUrl, "Twitter is not opened");
    }
        @Test
        public void verifyFacebook(){

            LogInPage logiin = new LogInPage();
            logiin.openPage().checkPage();
            Boolean resultLogIn2 = logiin.doLogin("standard_user", "secret_sauce").isHomePageOpened();
            Assert.assertTrue(resultLogIn2, "Home page is not opened");

            HomePage homepage1 = new HomePage();
            homepage1.clickByFbIcon();
            String expectedFaceBookUrl = "https://www.facebook.com/saucelabs";
            Assert.assertEquals(homepage1.getFbUrl(1), expectedFaceBookUrl, "Fb isn't opened");
        }



    }

