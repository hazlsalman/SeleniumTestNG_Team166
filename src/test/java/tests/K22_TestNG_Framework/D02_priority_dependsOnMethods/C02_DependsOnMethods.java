package tests.K22_TestNG_Framework.D02_priority_dependsOnMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethods {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        dependsOnMethods = "anasayfaTesti"

        1- siralama icin degil, method'lari birbirine baglamak icin kullanilir
           eger anasayfa testi calisip PASSED olmazsa
           phoneAramaTestini calistirmanin hicbir anlami olmayacaksa
           dependsOnMethods = "anasayfaTesti" yazabiliriz

        2- her test method'u bagimsiz olarak calistirilabilir
           ancak dependsOnMethods ile calismasi baska class'in calismasina baglanan bir method
           bagimsiz olarak calistirilmak istendiginde
           ONCE bagli oldugu method'u calistirir,
           O method calisip PASSED olursa, kendisi de calisir

           ANCAAAKKK bu sadece 2 method icin gecerlidir
           eger 3 method bu ornekte oldugu gibi birbirine bagli ise
           3.method'u bagimsiz calistirmak istedigimizde tum method'lar calismaz
            No tests were found ==> calistirilacak Test bulunamadi der

        3- Her ne kadar siralama icin kullanilmasa da
           dependsOnmethod kullanmis olan bir method'a sira geldiginde
           once bagli oldugu method'un calismasini saglayacagi icin
           otomatik olarak bir siralama da yapmis olur
     */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test
    public void anasayfaTesti(){

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik="testotomasyonu";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }


    @Test (dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){

        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        String unExpectedAramaSonucu="0 Products Found";
        String actualAramaSonucu=
                driver.findElement(By.xpath("//span[@class='product-count-text']")).getText();


        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);

    }


    @Test (dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){

        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]")).click();

        String expectedUrunIsmiIcerik="phone";
        String actualUrunIsmi=
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();


        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsmiIcerik));

    }


}
