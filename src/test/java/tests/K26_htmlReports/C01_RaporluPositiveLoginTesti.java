package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {

      /*
        TestNG kendisi HTML rapor olusturamaz

        HTML rapor olusturabilmek icin
        farkli dependency'ler kullanilabilir
        biz aventstack dependency kullandik

         aventstack raporlama icin 3 objeye ihtiyac duyar
         Bu objeleri her class'da olusturmak ve gerekli islemleri yapmak yerine
         bu islemleri bizim adimiza yapacak bir TestBaseRapor olusturduk

         olusturlmasi gereken 3 obje TestBaseRapor'da olusturuldu
         bu objeleri ve yapilan ayarlari kullanmanin
         en kisa yolu extends keyword ile TestBaseRapor'u parent edinmektir

         TestBaseRapor'da olusturulan 3 objeden
         extentReports ve extentHtmlReporter'a deger atamasi yapildi
         extentTest'e deger atamasi her test method'unda yapilmalidir

         HTML raporda gorunmesini istedigimiz test adimlarini
         extentTest objesi ile rapora isleyebiliriz
     */

    @Test
    public void positiveLoginTesti(){

        extentTest = extentReports.createTest("positive Login Testi",
                "Kullanici gecerli bilgilerle sisteme giris yapabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        extentTest.info("Kullanici test otomasyonu anasayfaya gider");

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        extentTest.info("Account linkine basar");


        // 3- Kullanici email'i olarak wisequarter@gmail.com girin
        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));

        extentTest.info("Email kutusuna olarak gecerli emaili yazar");


        // 4- Kullanici sifresi olarak 12345 girin
        testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        extentTest.info("Password kutusuna gecerli password'u yazar");


        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginSayfasiSubmitButton.click();

        extentTest.info("Login butonuna basarak login olur");


        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testOtomasyonuPage.logOutButton.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilabildigini test eder");


        // 7- logout olun
        testOtomasyonuPage.logOutButton.click();

        extentTest.info("Logout butonuna basarak sistemden cikis yapar");


        // 8- sayfayi kapatin
        extentTest.info("Sayfayi kapatir");


    }
}
