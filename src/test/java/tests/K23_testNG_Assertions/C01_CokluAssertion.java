package tests.K23_testNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_CokluAssertion {

    @Test
    public void ilkUrunIsimTesti(){


        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url verilen icerige sahip degil");

        // 2- nutella icin arama yapip

        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


        // urun bulunamadigini test edin

        //int actualBulunanUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        // Assert.assertEquals(actualBulunanUrunSayisi,0);
        // actulaBulunanUrunSayisi icin List kullanirsak
        // driver, List'e eklenecek WebElement bulmak icin
        //implicitly wait suresince bekleyecektir

        String actualAramaSonucYazisi=testOtomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"));

        // 3- belirlenen arama kelimesi icin arama yapip

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);

        ReusableMethods.bekle(1);


        // urun bulunabildigini test edin
        actualAramaSonucYazisi=testOtomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"));

        ReusableMethods.bekle(1);


        // 4- ilk urunu tiklayip,
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();


        // urun isminde case sensitive olmadan aranacak kelime bulundugunu test edin

        String expectedIsimIcerik=ConfigReader.getProperty("toAranacakKelime");

        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));


        // 5- sayfayi kapatin

        Driver.quitDriver();


    }
}
