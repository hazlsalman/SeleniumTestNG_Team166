package tests.K22_TestNG_Framework.D05_configurationDosyasiKullanma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DinamikNegativeLoginTesti {

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
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();


        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();


        //5- Basarili olarak giris yapilamadigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiSubmitButton.isDisplayed());

        Driver.quitDriver();


    }


    @Test
    public void gecersizEmailTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();


        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();


        //5- Basarili olarak giris yapilamadigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        Driver.quitDriver();
    }


    @Test (groups = {"E2E","smoke","regression"})
    public void gecersizEmailGecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2- account linkine basin
        testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSayfasiSubmitButton.click();
        ReusableMethods.bekle(2);


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginSayfasiPasswordKutusu.isDisplayed());

        Driver.quitDriver();


    }
}
