package tests.day17;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class C05_AmazonPageClass {

    @Test
    public void test() {
        AmazonPage amazonPage=new AmazonPage();
        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella için arama yapalım
        amazonPage.cookie.click();
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String expectedData="Nutella";
        String actualData=amazonPage.aramaSonucu.getText();
        Assert.assertTrue(actualData.contains(expectedData));
        Driver.closeDriver();

    }
}