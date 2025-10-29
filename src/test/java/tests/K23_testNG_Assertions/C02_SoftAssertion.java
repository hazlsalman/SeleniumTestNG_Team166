package tests.K23_testNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SoftAssertion {

    @Test(groups = "E2E")
    public void ilkUrunIsimTesti(){

        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert=new SoftAssert();

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url verilen icerige sahip degil");

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

        softAssert.assertEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi")
        ,"nutella icin arama sonucu bekleneden farkli");

        // 3- belirlenen arama kelimesi icin arama yapip

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);


        // urun bulunabildigini test edin
        actualAramaSonucYazisi=testOtomasyonuPage.aramaSonucuElementi.getText();

        softAssert.assertNotEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi")
        ,"Aranacak kelime arandiginda sonuc bekleneden farkli");


        // 4- ilk urunu tiklayip,
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();


        // urun isminde case sensitive olmadan aranacak kelime bulundugunu test edin

        String expectedIsimIcerik=ConfigReader.getProperty("toAranacakKelime");

        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik)
        ,"urun ismi aranacak kelimeyi icermiyor");


        // 5- sayfayi kapatin

        softAssert.assertAll();

        Driver.quitDriver();


    }
}
