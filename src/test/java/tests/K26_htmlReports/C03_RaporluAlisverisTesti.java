package tests.K26_htmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluAlisverisTesti extends TestBaseRapor {


   @Test
    public void alisverisTesti(){

       extentTest=extentReports.createTest("Alisveris Testi",
               "Kullanici sectigi urunun sepete eklendigini test eder");

       //1- https://www.testotomasyonu.com/ anasayfasina gidin
       Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

       extentTest.info("Kullanici testotomasyonu anasayfaya gider");


       //2- belirlenmis arama kelimesi icin arama yapin
       TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
       testOtomasyonuPage.aramaKutusu
               .sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);

       extentTest.info("Belirlenmis arama kelimesi icin arama yapar");


       //3- Listelenen sonuclardan ilkini tiklayin
       ReusableMethods.bekle(1);
       testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

       Actions actions =new Actions(Driver.getDriver());
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       ReusableMethods.bekle(1);

       extentTest.info("Listelene sonuclardan ilkine tiklar");


       //4- urun ismini kaydedin ve urunu sepete ekleyin
       String ilkUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText();
       testOtomasyonuPage.addToCartButton.click();

       actions.sendKeys(Keys.PAGE_UP).perform();
       ReusableMethods.bekle(3);

       extentTest.info("Urun ismini kaydeder ");
       extentTest.info("Urunu sepete ekler");


       //5- your cart linkine tiklayin
       testOtomasyonuPage.yourCartElementi.click();

       extentTest.info("your cart linkine tiklar");


       //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

       String sepettekiUrunIsmi=testOtomasyonuPage.sepettekiUrunIsimElementi.getText();
       ReusableMethods.bekle(1);

       Assert.assertEquals(sepettekiUrunIsmi,ilkUrunIsmi);

       extentTest.pass("Kaydettigi urun ismi ile sepetteki urun isminin ayni oldugunu test eder");


       //7- sayfayi kapatin
       extentTest.info("Sayfayi kapatir");


   }
}
