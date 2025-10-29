package tests.K22_TestNG_Framework.D06_DriverClassiDinamikYapma;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_AlisverisTesti {


    @Test(groups = "E2E")
    public void alisverisTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2- belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);


        //3- Listelenen sonuclardan ilkini tiklayin
        ReusableMethods.bekle(1);
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        Actions actions =new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);


        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String ilkUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText();
        testOtomasyonuPage.addToCartButton.click();

        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(3);


        //5- your cart linkine tiklayin
        testOtomasyonuPage.yourCartElementi.click();


        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi=testOtomasyonuPage.sepettekiUrunIsimElementi.getText();

        Assert.assertEquals(sepettekiUrunIsmi,ilkUrunIsmi);


        //7- sayfayi kapatin
        Driver.quitDriver();


    }
}
