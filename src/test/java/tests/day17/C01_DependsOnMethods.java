package tests.day17;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;
public class C01_DependsOnMethods extends TestBaseBeforeMethodAfterMethod {
    @Test(dependsOnMethods = "test01")
    public void test02() {
        driver.get("https://www.facebook.com");
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = -1)
    public void test04() {
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }
}