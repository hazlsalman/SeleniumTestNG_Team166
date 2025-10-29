package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C02_FacebookTesti {

    @Test
    public void negativeLoginTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");


        //2- Cookies cikiyorsa kabul edin
        //yok


        //3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        FacebookPage facebookPage=new FacebookPage();

        Faker faker=new Faker();

        facebookPage.loginSayfasiEmailKutusu.sendKeys(faker.internet().emailAddress());

        facebookPage.loginSayfasiPasswordKutusu.sendKeys(faker.internet().password());

        facebookPage.loginSayfasiLoginButton.click();


        //5- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.loginSayfasiEmailKutusu.isDisplayed());

        Driver.quitDriver();
    }
}
