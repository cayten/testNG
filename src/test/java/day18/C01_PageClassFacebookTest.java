package day18;


import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PageClassFacebookTest {

    Faker faker;
    @Test
    public void test() {
        FacebookPage facebookPage=new FacebookPage();
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        //POM'a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        //Faker class'ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin
        faker=new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();
        //Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.failedLogin.isDisplayed());
        Driver.closeDriver();
    }
}
