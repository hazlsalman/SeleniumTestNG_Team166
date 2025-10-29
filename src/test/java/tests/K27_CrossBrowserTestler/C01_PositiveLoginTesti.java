package tests.K27_CrossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_PositiveLoginTesti extends TestBaseCross {

    @Test
    public void positiveLoginTesti(){


        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
       driver.get(ConfigReader.getProperty("toUrl"));


        // 2- account linkine basin
        driver.findElement(By.xpath("//span[@class='menu-icon-text']")).click();


        // 3- Kullanici email'i olarak wisequarter@gmail.com girin

        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(ConfigReader.getProperty("toGecerliMail"));


        // 4- Kullanici sifresi olarak 12345 girin

        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));



        // 5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin")).click();



        // 6- Basarili olarak giris yapilabildigini test edin

        WebElement logoutButton=driver.findElement(By.xpath("//span[text()='Logout']"));

        Assert.assertTrue(logoutButton.isDisplayed());


        // 7- logout olun
        logoutButton.click();


        // 8- sayfayi kapatin
        driver.quit();

    }
}
