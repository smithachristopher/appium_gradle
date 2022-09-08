package testNG;

import Driver.BaseClass;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.SportsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest extends BaseClass {

    @Test(priority = 2)
    public void selectFromDropdown() {

        DashboardPage dashboardPage = new DashboardPage();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try{
            WebDriverWait wait = new WebDriverWait(driver, 60);
            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Categories");
            el1.isDisplayed();
            el1.click();
        }
        catch (ElementNotVisibleException e)
        {
            System.out.println("element not found"+e);
        }


        CategoriesPage categoriesPage=new CategoriesPage();
        categoriesPage.scrollAndClick("Sports");
        SportsPage sportsPage = new SportsPage();
        sportsPage.hamburger.isDisplayed();
        Select select= new Select(sportsPage.hamburger);
        select.selectByVisibleText("Issues");

    }
    }

