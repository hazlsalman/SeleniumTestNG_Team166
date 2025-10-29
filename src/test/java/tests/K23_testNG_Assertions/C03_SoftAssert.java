package tests.K23_testNG_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C03_SoftAssert {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));


        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        String expectedUrl=ConfigReader.getProperty("zeroUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"url beklenenden farkli");


        // 3. Sign in butonuna basin
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.anasayfaSignInButton.click();


        // 4. Login kutusuna “username” yazin
        zeroPage.loginKutusu.sendKeys("username");


        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");


        // 6. Sign in tusuna basin
        zeroPage.loginPageSignInButton.click();


        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();


        // 8. Giris yapilabildigini dogrulayin

        softAssert.assertTrue(zeroPage.aramaKutusu.isDisplayed());


        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingMenu.click();


        //10. Pay Bills sayfasina gidin
        zeroPage.payBillsLink.click();


        //11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrency.click();


        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin

        softAssert.assertTrue(zeroPage.currencyDdm.isEnabled());


        //13. “Currency” dropdown menusunden Eurozone’u secin

        Select select=new Select(zeroPage.currencyDdm);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedSelect="Eurozone (euro)";
        String actualSelect=select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSelect,expectedSelect,"Eurozone secili degil");


        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        List<WebElement> currencyDdmMenu=select.getOptions();

        int expectedDdmMenuOption=16;
        int actualDdmMenuOption=currencyDdmMenu.size();

        softAssert.assertEquals(actualDdmMenuOption,expectedDdmMenuOption
        ,"Dropdown menu beklenen sayida option icermiyor");


        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        boolean menudeCanadaVarMi=false;

        for (int i = 0; i <currencyDdmMenu.size() ; i++) {

            if (currencyDdmMenu.get(i).getText().equalsIgnoreCase("Canada (dollar)")){
                menudeCanadaVarMi=true;
                break;
            }
        }

        softAssert.assertTrue(menudeCanadaVarMi,"Dropdown menude canada secenegi yok");


        softAssert.assertAll();
        //17. Sayfayi kapatin
        Driver.quitDriver();


    }
}
