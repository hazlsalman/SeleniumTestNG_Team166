package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "signin_button")
    public WebElement anasayfaSignInButton;


    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginKutusu;


    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordKutusu;


    @FindBy(xpath = "//input[@name='submit']")
    public WebElement loginPageSignInButton;


    @FindBy(id = "searchTerm")
    public WebElement aramaKutusu;


    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenu;


    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBillsLink;


    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;


    @FindBy(id = "pc_currency")
    public WebElement currencyDdm;


}
