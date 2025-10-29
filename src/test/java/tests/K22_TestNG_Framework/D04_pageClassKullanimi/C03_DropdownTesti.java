package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DropdownTesti {

    @Test
    public void dropdownTesti(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");


        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestOtomasyonuFormPage testOtomasyonuFormPage=new TestOtomasyonuFormPage();
        Select selectGun=new Select(testOtomasyonuFormPage.gunDDM);
        selectGun.selectByIndex(5);


        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy=new Select(testOtomasyonuFormPage.ayDDM);
        selectAy.selectByValue("nisan");



        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil=new Select(testOtomasyonuFormPage.yilDDM);
        selectYil.selectByVisibleText("1990");


        //5- Secilen değerleri konsolda yazdirin

        System.out.println(
                selectGun.getFirstSelectedOption().getText()+
                        selectAy.getFirstSelectedOption().getText()+
                        selectYil.getFirstSelectedOption().getText()
        );


        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

      ReusableMethods.stringListeDondur(selectAy.getOptions());


        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedAyDdmBoyutu=13;
        int actualAyDdmBoyutu=selectAy.getOptions().size();

        Assert.assertEquals(actualAyDdmBoyutu,expectedAyDdmBoyutu);

        Driver.quitDriver();

    }
}
