package tests.day19_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C05_DriverClassKullanimi {

    @Test
    public void aramaTesti() throws InterruptedException {

        /*
            TestNG Page Object Model kullanır

            Temel hedefimiz
            Test class'i içinde dinemik olmayan hiç bir data kalmaması
            (değeri değiştinde düzeltmek için test class'ına gelme mecburiyeti olmayan)
         */
        Driver.getDriver().get("https://www.testotomasyonu.com");
        Thread.sleep(2000);

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        Thread.sleep(2000);

        WebElement sonucYaziElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertNotEquals(actualSonucYazisi, unExpectedSonucYazisi);
        Driver.quitDriver();

    }
}
