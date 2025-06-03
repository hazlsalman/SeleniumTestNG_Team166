package tests.day21_pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebappPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C05_SoftAssertion {



    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = ConfigReader.getProperty("zeroUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl, "url expected url'den farklı");

        // 3. Sign in butonuna basin
        ZeroWebappPage zeroWebappPage = new ZeroWebappPage();
        zeroWebappPage.ilkSayfaSignInLinki.click();

        // 4. Login kutusuna “username” yazin
        zeroWebappPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroUsername"));
        ReusableMethods.bekle(2);

        // 5. Password kutusuna “password” yazin
        zeroWebappPage.passWordKutusu.sendKeys(ConfigReader.getProperty("zeroPassword"));
        ReusableMethods.bekle(2);

        // 6. Sign in tusuna basin
        zeroWebappPage.loginSayfasiSignInButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebappPage.settingsLinki.isDisplayed(), "sisteme giriş yapılamadı");

        // 9. Online banking menusunu tiklayin
        zeroWebappPage.onlineBankingMenu.click();

        //10. Pay Bills sayfasina gidin
        zeroWebappPage.payBillsLink.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebappPage.purchaseForeignCurrencyLinki.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebappPage.dropDownCurrencyMenu.isEnabled(), "menuye erişilemiyor");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        zeroWebappPage.dropDownCurrencyMenu.click();

        Select selectUlke = new Select(zeroWebappPage.dropDownCurrencyMenu);
        selectUlke.getOptions().get(6).click();

        //14. "Eurozone (euro)" secildigini dogrulayin
        softAssert.assertTrue(selectUlke.getOptions().get(6).getText().contains("Eurozone (euro)"), "seçilemedi");


        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        List<WebElement> optionList = selectUlke.getOptions();
        int expectedOptionSayisi = 16;
        int actualOptionSayisi = optionList.size();
        softAssert.assertEquals(actualOptionSayisi, expectedOptionSayisi, "option sayısı 16 değil");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        softAssert.assertTrue(ReusableMethods.stringListeDonustur(optionList).contains("Canada (dollar)"), "canada içermiyor");

        //17. Sayfayi kapatin
        Driver.quitDriver();

        softAssert.assertAll();


    }
}
