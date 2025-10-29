package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C01_PageClassKullanimi {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin


    @Test
    public void anasayfaTesti(){

        //testotomasyonu anasayfaya gidip

        Driver.getDriver().get("https://www.testotomasyonu.com");

       // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }



    @Test (dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){

        // phone icin arama yapip

        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // urun bulunabildigini test edin

        int actualBulunanUrunSayisi= testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi>0);


    }



    @Test (dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsmiTesti(){

        // ilk urunu tiklayip

        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        //  urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik="phone";
        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();

    }


}
