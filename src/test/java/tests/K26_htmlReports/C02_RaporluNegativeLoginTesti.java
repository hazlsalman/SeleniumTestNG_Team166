package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin



    TestOtomasyonuPage testOtomasyonuPage;

    @Test
    public void gecersizPasswordTesti(){

        extentTest=extentReports.createTest("gecersiz password testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        extentTest.info("Test otomasyonu anasayfaya gider");


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        extentTest.info("Account linkine tiklar");


        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Email kutusuna gecerli email yazar ");

        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password yazar");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();

        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiSubmitButton.isDisplayed());

        extentTest.pass("Basarili olarak giris yapamadigini test eder");


        extentTest.info("Sayfayi kapatir");


    }


    @Test
    public void gecersizEmailTesti(){

        extentTest=extentReports.createTest("gecersiz email testi",
                "Kullanici gecerli password ve gecersiz email ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("Account linkine tiklar");


        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("Email kutusuna gecersiz email yazar");
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli password yazar");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();
        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilmadigini test eder");

        extentTest.info("sayfayi kapatir");
    }


    @Test
    public void gecersizEmailGecersizPasswordTesti(){

        extentTest=extentReports.createTest("gecersiz email gecersiz password testi",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("Account linkine tiklar");

        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));

        extentTest.info("Email kutusuna gecersiz email yazar");

        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        extentTest.info("Password kutusuna gecersiz password yazar");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();
        ReusableMethods.bekle(2);

        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiPasswordKutusu.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

       extentTest.info("Sayfayi kapatir");


    }


}


