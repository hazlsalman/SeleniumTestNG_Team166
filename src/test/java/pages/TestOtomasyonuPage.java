package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "//span[@class='menu-icon-text']")
    public WebElement accountLinki;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginSayfasiPasswordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginSayfasiSubmitButton;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//span[text()='Your Cart'])[1]")
    public WebElement yourCartElementi;

    @FindBy(xpath = "//a[@class='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;

    @FindBy(xpath = "//span[@class='product-count-text']")
    public WebElement aramaSonucuElementi;



}
