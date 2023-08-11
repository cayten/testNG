package day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    @Test
    public void test() throws IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://hepsiburada.com");
        //Ve sayfanın resmini alınız
        ReusableMethods.getScreenshot("hepsiburadanin tum ekran resmi");
        //Sayfayı kapatınız
        Driver.closeDriver();
    }

    @Test
    public void test2() throws IOException {
        AmazonPage page=new AmazonPage();
        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        page.cookie.click();
        //Nutella aratınız
        page.searchBox.sendKeys("nutella"+ Keys.ENTER);
        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("Aramasonucunun ekran resmi",page.aramaSonucu);
    }
}