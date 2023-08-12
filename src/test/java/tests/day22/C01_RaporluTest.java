package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
     /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test() {
        BrcPage page = new BrcPage();
        extentTest = extentReports.createTest("pozitif test", "kullanici login islemler");
        Driver.getDriver().get(ConfigReader.getProperty("BrcUrl"));
        extentTest.info("Blue rent a car sitesine gidildi");
        page.brclogin.click();
        extentTest.info("login butonuna basildi");
        page.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanici ve password girildi");
        extentTest.info("ikinci login butonuna basildi");

        String actualData=page.basariliGiris.getText();
        String expectedData="cuneyt soylu";
        Assert.assertEquals(expectedData,actualData);
        extentTest.pass("Sayfaya basarili bir sekilde giris yapildi");

    }
}